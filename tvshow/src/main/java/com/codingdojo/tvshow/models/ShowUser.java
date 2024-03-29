package com.codingdojo.tvshow.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="showuser")
public class ShowUser {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
		
    @Column(updatable=false)
    private Date createdAt;
    
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
    	this.createdAt = new Date();
    }
    
    @PreUpdate
    protected void onUpdate(){
    	this.updatedAt = new Date();
    }
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="show_id")
    private Show show;
    
    
    
    
 
    public ShowUser() {
        
    }

    public ShowUser(Long id, User user, Show show) {
    	this.user = user;
    	this.show = show;
    }
    

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Show getShow() {
		return show;
	}


	public void setShow(Show show) {
		this.show = show;
	}



}


