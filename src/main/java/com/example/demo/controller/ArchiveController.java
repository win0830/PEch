package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.ThreadsForm;
import com.example.demo.model.ThreadsRepos;
import com.google.gson.Gson;

import com.example.demo.model.CreateThreadForm;
import com.example.demo.model.Threads;

@Controller
public class ArchiveController {
	
	@Autowired
	private ThreadsRepos threadsRepos;
	
	// ページ表示
	@RequestMapping("/archive")
	public String getArchive() {
		return "PEch/archive";
	}
	
	// スレッド一覧表示
	@RequestMapping(value = "getThreads", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			method = RequestMethod.GET)
	@ResponseBody
	public String getTreads(@RequestBody ThreadsForm form) {
		int page = form.getPage();
		int threadsCount = form.getThreadsCount();
		List<Threads> threads = threadsRepos.findByAllOrderByPostTimeDesc();
		return new Gson().toJson(threads);
	}

	@RequestMapping("/createThread")
	public String createThread(CreateThreadForm createThreadForm) {
		
		return "PEch/archive";
	}
}
