package com.codingdojo.book.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.book.models.Book;
import com.codingdojo.book.services.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	///////////////////////////////////Show_all_books///////////////////////////////
	@GetMapping("/")
	public String home(Model model) {
		List<Book> allbooks = bookService.getAllBooks();
		model.addAttribute("Books",allbooks);
		return "books/index.jsp";
	}
	///////////////////////////////////create_page///////////////////////////////

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("newBook",new Book());
		return "books/create.jsp";
	}
	///////////////////////////////////create_process///////////////////////////////

	@PostMapping("/create_process")
	public String createBook(@Valid @ModelAttribute("newBook") Book newbook, BindingResult results) {
		if(results.hasErrors()) {
			return "books/create.jsp";
		}else {
			bookService.createOrUpdateBook(newbook);
			return "redirect:/";
		}
	}
	///////////////////////////////////show///////////////////////////////

	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Book thisBook= bookService.getThisBook(id);
		model.addAttribute("thisbook",thisBook);
		return "books/show.jsp";
	}
	
	///////////////////////////////////update_page///////////////////////////////
	@GetMapping("/update/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Book editBook= bookService.getThisBook(id);
		model.addAttribute("editbook",editBook);
		return "books/edit.jsp";
	}
	///////////////////////////////////update_page///////////////////////////////
	@PutMapping("/update_process/{id}")
	public String updateBook(@Valid @ModelAttribute("editbook") Book newbook, BindingResult results) {
		if(results.hasErrors()) {
			return "books/edit.jsp";
		}else {
			bookService.createOrUpdateBook(newbook);
			return "redirect:/";
		}
	}
///////////////////////////////////delete///////////////////////////////
	@DeleteMapping("/delete/{id}")
	public String deleteBook( @PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/";
		}
}
