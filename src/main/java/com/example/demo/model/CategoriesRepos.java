package com.example.demo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepos extends JpaRepository<Categories, Integer>{
	List<Categories> findByCategoryName(String categoryName);
}
