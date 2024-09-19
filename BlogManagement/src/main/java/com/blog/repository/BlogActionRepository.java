package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.entity.BlogAction;

@Repository
public interface BlogActionRepository extends JpaRepository<BlogAction, Integer> {

}
