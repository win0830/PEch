package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CreateThreadForm;
import com.example.demo.model.Threads;
import com.example.demo.model.ThreadsRepos;


@Service
public class ThreadService {
	@Autowired
	private ThreadsRepos threadsRepos;
	
	public void insertThread(CreateThreadForm createThreadForm ) {
		Threads thread = new Threads();
		
		thread.set
		
		threadsRepos.save(thread);
	}
}
