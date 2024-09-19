package com.blog.entity;

import com.blog.blogtype.*;
import java.util.Date;

//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;

@Entity
public class Blog {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int blogid;
	private String content;
	private String title;
	private String image;
	private Date date;
	private boolean isdeleted;

	 private BlogType blogType;
	 
	 @ManyToOne
	 @JoinColumn(name="blogcategory_id")
	 private BlogCategory blogcategory;
	 
	 @Temporal(TemporalType.TIMESTAMP)
	 private Date creationTime;
	 
	 @Temporal(TemporalType.TIMESTAMP)
	 private Date modificationTime;
	 
	 @PrePersist
	 protected void onCreation() {
		 creationTime=new Date();
		 modificationTime=creationTime;
	 }
	 @PreUpdate
	 protected void onUpdate() {
		 modificationTime=new Date();
	 }
	
	public Blog() {
		
	}
	
	
	public Blog(int blogid, String content, String title, String image, Date date, boolean isdeleted, BlogType blogType,
			BlogCategory blogcategory, Date creationTime, Date modificationTime) {
		super();
		this.blogid = blogid;
		this.content = content;
		this.title = title;
		this.image = image;
		this.date = date;
		this.isdeleted = isdeleted;
		this.blogType = blogType;
		this.blogcategory = blogcategory;
		this.creationTime = creationTime;
		this.modificationTime = modificationTime;
	}

	public int getBlogid() {
		return blogid;
	}

	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}

	public BlogType getBlogType() {
		return blogType;
	}

	public void setBlogType(BlogType blogType) {
		this.blogType = blogType;
	}

	public BlogCategory getBlogcategory() {
		return blogcategory;
	}

	public void setBlogcategory(BlogCategory blogcategory) {
		this.blogcategory = blogcategory;
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
