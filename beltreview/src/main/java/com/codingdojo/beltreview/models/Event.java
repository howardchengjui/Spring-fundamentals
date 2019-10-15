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
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Size(min=1,message="Event name must exist!")
    private String name;
	@Future
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
 	@Size(min=2,message="City is required!")
 	private String city;
	@Size(min=2,message="State is required!")
 	private String state;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User host;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    	name = "attending",
    	joinColumns=@JoinColumn(name="event_id"),
    	inverseJoinColumns= @JoinColumn(name="user_id")
    )
    private List<User> UsersAttending;
    
    public Event() {
    }

	public Event(String name, Date date,
			 String city, String state, User host,
			 List<User> usersAttending) {

		this.name = name;
		this.date = date;
		this.city = city;
		this.state = state;
		this.host = host;
		UsersAttending = usersAttending;
	}

	
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
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



	public User getHost() {
		return host;
	}



	public void setHost(User host) {
		this.host = host;
	}



	public List<User> getUsersAttending() {
		return UsersAttending;
	}



	public void setUsersAttending(List<User> usersAttending) {
		UsersAttending = usersAttending;
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
