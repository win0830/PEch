package com.example.demo.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ResesRepos extends JpaRepository<Reses, Integer>{
	List<Reses> findByThreadsOrderByPostTimeAsc(Threads threads);
}
