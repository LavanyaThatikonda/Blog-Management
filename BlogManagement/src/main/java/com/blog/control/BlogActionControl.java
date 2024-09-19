package com.blog.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.entity.BlogAction;
import com.blog.service.BlogActionService;

@RestController
@RequestMapping("/blogaction")
public class BlogActionControl {
	@Autowired
	private BlogActionService blogActionService;
	
	@PostMapping("/create")
	public BlogAction createBlogAction(@RequestBody BlogAction blogaction) {
		
		return  blogActionService.createBlogAction(blogaction);
	}

}
