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


import com.blog.entity.BlogComment;
import com.blog.service.BlogCommentService;

@RestController
@RequestMapping("/blogcomment")
public class BlogCommentControl {
	
	@Autowired
	private BlogCommentService blogCommentService;
	
  @PostMapping("/create")
	public BlogComment createBlogComment(@RequestBody BlogComment blogComment) {
		return blogCommentService.createBlogComment(blogComment);
		
	}
  @DeleteMapping("/delete/{id}")
  public void deleteBlogComment(@PathVariable int id,BlogComment blogComment) {
	  blogCommentService.deleteBlogComment(id);
  }
  @PutMapping("/edit/{id}")
  public BlogComment editBlogComment(@PathVariable int id, @RequestBody BlogComment updatedComment) {
      return blogCommentService.editBlogComment(id, updatedComment);
  }

  @DeleteMapping("/deleteall")
  public void deleteAll() {
      blogCommentService.deleteAll();
  }
  @GetMapping("/getall")
	public List<BlogComment>findAll(){
		return blogCommentService.getAllComments();
	}
}
