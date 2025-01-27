package com.blog.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.entity.BlogCategory;


@Repository
public interface BlogCategoryRepository extends JpaRepository<BlogCategory,Integer>{

	

	Object findByTitle(String title);

	
	

}
