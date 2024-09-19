package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.Blog;
import com.blog.repository.BlogRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BlogService {
	
	@Autowired
	private BlogRepository blogRepository;
	
//	public Blog createBlog(Blog blog)  {
//        // Check if the blog already exists in the category
//       if(blogRepository.findByTitle(blog.getTitle()!=null)) {
//    	   throw new RuntimeException("blog title is alredy exits");
//    	   
//       }
//        return blogRepository.save(blog);
//    }
	public Blog createBlog(Blog blog) {
        // Check if the blog already exists in the category
        Blog existingBlog = blogRepository.findByTitle(blog.getTitle());
        if (existingBlog != null) {
            throw new RuntimeException("Blog title already exists");
        }
        return blogRepository.save(blog);
    }

	public void deleteBlog(int id) {
		Blog blog=blogRepository.findById((int) id)
				.orElseThrow(()-> new EntityNotFoundException("blog not found"));
		blogRepository.delete(blog);
	}
	
	public Blog updateBlog(int id,Blog blog) {
		Blog existingblog=blogRepository.findById((int) id)
			.orElseThrow(()-> new EntityNotFoundException("blog not found"));
		existingblog.setTitle(blog.getTitle());
		existingblog.setContent(blog.getContent());
		existingblog.setImage(blog.getImage());
		existingblog.setDate(blog.getDate());
		return blogRepository.save(existingblog);
		
	}
	public Blog getBlogById(int id) {
		return blogRepository.findById((int) id)
				.orElseThrow(()->new EntityNotFoundException("blog not found with this id"));
	}
	
	public List<Blog> getAll(){
		return blogRepository.findAll();
	}
}
