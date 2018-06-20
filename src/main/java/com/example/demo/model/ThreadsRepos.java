package com.example.demo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ThreadsRepos extends JpaRepository<Threads, Integer>{
	List<Threads> findByCategories(Categories categories);
	List<Threads> findByAllOrderByPostTimeDesc();
}
