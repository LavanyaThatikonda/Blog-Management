package com.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.BlogAction;
import com.blog.repository.BlogActionRepository;

@Service
public class BlogActionService {
	@Autowired
	private BlogActionRepository blogActionRepository;
	
	public BlogAction createBlogAction(BlogAction blogAction) {
		return blogActionRepository.save(blogAction);
	}

}
