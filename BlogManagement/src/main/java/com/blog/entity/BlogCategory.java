package com.blog.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class BlogCategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationTime;
	
	@PrePersist
	protected void onCreate() {
		creationTime=new Date();
		modificationTime =creationTime;
		
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationTime;
	
	@PreUpdate
	protected void onUpdate() {
		modificationTime=new Date();
	}

	public BlogCategory() {
		
	}
	
	

	public BlogCategory(int id, String title, String description, Date creationTime, Date modificationTime) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.creationTime = creationTime;
		this.modificationTime = modificationTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(Date modificationTime) {
		this.modificationTime = modificationTime;
	}
	
	

	
	
}
