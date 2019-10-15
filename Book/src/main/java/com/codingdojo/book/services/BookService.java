package com.codingdojo.book.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.book.models.Book;
import com.codingdojo.book.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;

	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	public void createOrUpdateBook(@Valid Book newbook) {
		// TODO Auto-generated method stub
		bookRepository.save(newbook);
	}

	public Book getThisBook(Long id) {
		// TODO Auto-generated method stub
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		}
		return null;
	}

	public void deleteBook(Long id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);
	}
	
	
}
