package com.blog.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class BlogAction {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private boolean islike;
	 
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationTime;
	
	@PrePersist
	protected void onCreation() {
		creationTime=new Date();
		modificationTime=creationTime;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificationTime;
	
	protected void onUpdate() {
		modificationTime=new Date();
		
	}
	
	public BlogAction() {
		
	}

	public BlogAction(int id, boolean islike, Date creationTime, Date modificationTime) {
		super();
		this.id = id;
		this.islike = islike;
		this.creationTime = creationTime;
		this.modificationTime = modificationTime;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isIslike() {
		return islike;
	}

	public void setIslike(boolean islike) {
		this.islike = islike;
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
