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

import com.blog.entity.BlogCategory;
import com.blog.service.BlogCategoryService;

@RestController
@RequestMapping("blogcategory")
public class BlogCategoryControl {
	
	@Autowired
	private BlogCategoryService blogCategoryService;
	
	@PostMapping("/create")
	public BlogCategory createBlogCategory(@RequestBody BlogCategory blogCategory ) {
		return blogCategoryService.createBlogCategory(blogCategory);
	}
	@DeleteMapping("/delete")
	public void deleteBlogCategory(@PathVariable int id) {
		blogCategoryService.deleteBlogCategory(id);
	}
	@PutMapping("/update")
	public BlogCategory updateBlogCategoryById(@PathVariable int id,@RequestBody BlogCategory blogCategory ) {
		return blogCategoryService.updateBlogCategory(id, blogCategory);
	}
	@GetMapping("/get")
	
	public BlogCategory getBlogCategoryById(@PathVariable int id) {
		return blogCategoryService.getBlogCategoryById(id);
	}
	@GetMapping("/getall")
	public List<BlogCategory>getAll(){
		return blogCategoryService.getAllCategories();
	}
}

