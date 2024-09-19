package com.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.blog.entity.BlogCategory;
import com.blog.repository.BlogCategoryRepository;


import jakarta.persistence.EntityNotFoundException;

@Service
public class BlogCategoryService {
	@Autowired
	private BlogCategoryRepository blogCategoryRepository;
	
	
	public BlogCategory createBlogCategory(BlogCategory blogCategory) {
        if (blogCategoryRepository.findByTitle(blogCategory.getTitle()) != null) {
            throw new RuntimeException("Category With this name already exists");
        }
        return blogCategoryRepository.save(blogCategory);
    }
    

    public void deleteBlogCategory(int id) {
	  BlogCategory category=blogCategoryRepository.findById(id)
			  .orElseThrow(()-> new EntityNotFoundException("category not found"));
	  blogCategoryRepository.delete(category);
	  
      }
    
    public BlogCategory updateBlogCategory(int id, BlogCategory blogCategory) {
    	BlogCategory existingcategory =blogCategoryRepository.findById(id)
    			.orElseThrow(()-> new EntityNotFoundException("category not found"));
    	existingcategory.setTitle(blogCategory.getTitle());
    	existingcategory.setDescription(blogCategory.getDescription());
    	return blogCategoryRepository.save(existingcategory);
    }
    
//    public BlogCategory getBlogCategoryById(int id) {
//    	return blogCategoryRepository.findById(id)
//    			.orElseThrow(()->new EntityNotFoundException("product not found with this " + id));
//    }
//    
    
    public BlogCategory getBlogCategoryById(int id) {
        return blogCategoryRepository.findById(id)
         .orElseThrow(() -> new EntityNotFoundException("BlogCategory not found with id: " + id));
    }
    public List<BlogCategory> getAllCategories(){
    	return  blogCategoryRepository.findAll();
    }
   

}
