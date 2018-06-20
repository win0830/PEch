package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepos extends JpaRepository<Users, Integer>{
	Users findByUserId(String userId);
}
