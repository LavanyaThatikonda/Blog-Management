package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.blog.entity.BlogComment;
import com.blog.repository.BlogCommentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BlogCommentService {
	@Autowired
	private BlogCommentRepository blogCommentRepository;
	
	
	public BlogComment createBlogComment(BlogComment blogComment) {
        // Pass the BlogComment object to the save method
        return blogCommentRepository.save(blogComment);
    }
	 
//	public BlogComment createBlogComment(BlogComment blogComment) {
//	    return  blogCommentRepository.save("blogComment");
//	}
   public void deleteBlogComment(int id) {
	   BlogComment blogComment = blogCommentRepository.findById(id)
       .orElseThrow(() -> new EntityNotFoundException("Blog comment not found with id: " + id));
   
	   blogCommentRepository.delete(blogComment);
   }
   
   public BlogComment editBlogComment(int id, BlogComment updatedComment) {
	    BlogComment blogComment = blogCommentRepository.findById(id)
	        .orElseThrow(() -> new EntityNotFoundException("Blog comment not found with id: " + id));

	   
	    return blogCommentRepository.save(blogComment);
	}
   
   
    public void deleteAll() {
    	blogCommentRepository.deleteAll();
    }
    public List<BlogComment> getAllComments(){
    	return  blogCommentRepository.findAll();
    }
}
