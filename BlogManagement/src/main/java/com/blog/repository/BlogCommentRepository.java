package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.entity.BlogComment;


@Repository
public interface BlogCommentRepository extends JpaRepository<BlogComment, Integer> {
    // Ensure that the save method accepts a BlogComment object
    @Override
    BlogComment save(BlogComment blogComment);
}


