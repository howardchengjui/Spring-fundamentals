package com.codingdojo.tvshow.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.codingdojo.tvshow.models.Show;

@Entity
@Table(name="users")
public class User {
	 	@Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long id;
	 	@Email(message="Email must be valid!")
	    private String email;
	 	@Size(min=8,message="Password must be at least 8 characters long!")
	    private String password;
	 	@Size(min=1,message="Name is required!")
	 	private String name;

	 	@Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    @Transient
	    private String passwordConfirmation;
	    
	    @OneToMany(mappedBy="host",fetch = FetchType.LAZY)
	    private List<Show> shows;
	    
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	    	name = "rating",
	    	joinColumns=@JoinColumn(name="user_id"),
	    	inverseJoinColumns= @JoinColumn(name="show_id")
	    )
	    private List<Show> showsrated;
	    
	    public User() {
	    }
	   
		public User(Long id, @Email(message = "Email must be valid!") String email,
				@Size(min = 8, message = "Password must be at least 8 characters long!") String password,
				@Size(min = 1, message = "Name is required!") String name, String passwordConfirmation,
				List<Show> shows, List<Show> showsrated) {
			this.id = id;
			this.email = email;
			this.password = password;
			this.name = name;
			this.passwordConfirmation = passwordConfirmation;
			this.shows = shows;
			this.showsrated = showsrated;
		}


		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public String getPasswordConfirmation() {
			return passwordConfirmation;
		}

		public void setPasswordConfirmation(String passwordConfirmation) {
			this.passwordConfirmation = passwordConfirmation;
		}

		public List<Show> getShows() {
			return shows;
		}

		public void setShows(List<Show> shows) {
			this.shows = shows;
		}

		public List<Show> getShowsrated() {
			return showsrated;
		}

		public void setShowsrated(List<Show> showsrated) {
			this.showsrated = showsrated;
		}

		@PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
}
