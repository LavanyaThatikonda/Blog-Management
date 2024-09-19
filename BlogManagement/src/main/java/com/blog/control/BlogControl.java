package com.blog.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.entity.Blog;
import com.blog.entity.BlogCategory;
import com.blog.service.BlogCategoryService;
import com.blog.service.BlogService;

@RestController
@RequestMapping("/blog")
public class BlogControl {
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
    private BlogCategoryService blogCategoryService;
	
	    @PostMapping("/create")
	   public Blog createBlog(@RequestBody Blog blog) {
	      BlogCategory blogCategory = blogCategoryService.getBlogCategoryById(blog.getBlogcategory().getId());
	       blog.setBlogcategory(blogCategory);
	        return blogService.createBlog(blog);
	       }
	 
	  @DeleteMapping("/delete")
	 public void deleteBlog(@PathVariable int id) {
		 blogCategoryService.deleteBlogCategory(id);
	 }
	 
	  @PutMapping("/update")
	  public Blog updateBlog(@PathVariable int id,@RequestBody Blog blog) {
		  return blogService.updateBlog(id, blog);
	  }
	  
	   @GetMapping("/get/{id}")
	    public Blog getBlogById(@PathVariable int id) {
	    	return blogService.getBlogById(id);
	    }
	 
	    @GetMapping("/getall")
	    public List<Blog>findAll(){
	    	return blogService.getAll();
	    }
}
