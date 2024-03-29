package com.codingdojo.beltreview.models;

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
	 	@Size(min=1,message="First name is required!")
	 	private String firstName;
	 	@Size(min=1,message="Last name is required!")
	 	private String lastName;
	 	@Size(min=2,message="City is required!")
	 	private String city;
	 	@Size(min=2,message="State is required!")
	 	private String state;
	 	@Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    @Transient
	    private String passwordConfirmation;
	    
	    @OneToMany(mappedBy="host",fetch = FetchType.LAZY)
	    private List<Event> events;
	    
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	    	name = "attending",
	    	joinColumns=@JoinColumn(name="user_id"),
	    	inverseJoinColumns= @JoinColumn(name="event_id")
	    )
	    private List<Event> eventsAttending;

	    
	    public User() {
	    }
	   
		public User(Long id, String email, String password, String firstName,
				 String lastName,
				 String city,
				 String state, String passwordConfirmation,
				List<Event> events, List<Event> eventsAttending) {
			super();
			this.id = id;
			this.email = email;
			this.password = password;
			this.firstName = firstName;
			this.lastName = lastName;
			this.city = city;
			this.state = state;
			this.passwordConfirmation = passwordConfirmation;
			this.events = events;
			this.eventsAttending = eventsAttending;
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

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getPasswordConfirmation() {
			return passwordConfirmation;
		}

		public void setPasswordConfirmation(String passwordConfirmation) {
			this.passwordConfirmation = passwordConfirmation;
		}

		public List<Event> getEvents() {
			return events;
		}

		public void setEvents(List<Event> events) {
			this.events = events;
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

		public List<Event> getEventsAttending() {
			return eventsAttending;
		}

		public void setEventsAttending(List<Event> eventsAttending) {
			this.eventsAttending = eventsAttending;
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
