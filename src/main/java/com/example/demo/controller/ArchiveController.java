package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.ThreadsForm;
import com.example.demo.model.ThreadsRepos;
import com.google.gson.Gson;
<<<<<<< HEAD
import com.example.demo.SessionModel;
=======
import com.example.demo.model.Categories;
import com.example.demo.model.CategoriesRepos;
>>>>>>> refs/remotes/origin/master
import com.example.demo.model.CreateThreadForm;
import com.example.demo.model.Reses;
import com.example.demo.model.ResesRepos;
import com.example.demo.model.Threads;

@Controller
public class ArchiveController {
	
	@Autowired
	private ThreadsRepos threadsRepos;
	@Autowired
	private ResesRepos resesRepos;
	@Autowired
<<<<<<< HEAD
	private SessionModel sessionModel;
=======
	private CategoriesRepos categoriesRepos;
>>>>>>> refs/remotes/origin/master
	
	// show page
	@RequestMapping("/archive")
	public String getArchive(Model model) {
		model.addAttribute("user_name", sessionModel.getUserName());//ユーザーネーム表示
		return "PEch/archive";
	}
	
	@RequestMapping("/createThread")
	public String createThread(CreateThreadForm createThreadForm) {
		
		return "PEch/archive";
	}
	
	// show thread all 
	@RequestMapping(value = "getThreads", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			method = RequestMethod.GET)
	@ResponseBody
	public String getTreads() {
		List<Reses> reses = resesRepos.findAll(new Sort(Sort.Direction.DESC,"postTime"));
		List<Threads> threads = new ArrayList<>();
		threads.add(threadsRepos.findById(reses.get(0).getThreads().getThreadId()).get());
		for(int i = 0; i < reses.size(); i++) {
			if(threads.indexOf(reses.get(i).getThreads()) == -1) {
				threads.add(threadsRepos.findById(reses.get(i).getThreads().getThreadId()).get());	
			}
		}
		return new Gson().toJson(threads);
	}

<<<<<<< HEAD
	@RequestMapping("/createThread")
	public String createThread(CreateThreadForm createThreadForm, Model model) {
		model.addAttribute("user_name", sessionModel.getUserName());//ユーザーネーム表示
		return "PEch/archive";
=======
	
	
	@RequestMapping(value = "searchThreads", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			method = RequestMethod.GET)
	@ResponseBody
	public String searchThreads(@RequestBody ThreadsForm form) {
		List<Threads> threads = new ArrayList<>();
		if(form.getCategory() != null) {
		List<Categories> cate = categoriesRepos.findByCategoryName(form.getCategory());
			threads.addAll(threadsRepos.findByCategories(cate.get(0)));
		}
		if(form.getSerchWord() != null) {
			threads.addAll(threadsRepos.findByThreadNameContaining(form.getSerchWord()));
		}
		
		for(int i = 0 ; i < threads.size() ; i++) {
			for(int j = 0 ; j < threads.size() ; j++) {
				if(threads.get(i).getThreadId() == threads.get(j).getThreadId() && i != j) {
					threads.remove(i);
				}
			}
		}
		
		return new Gson().toJson(threads);
>>>>>>> refs/remotes/origin/master
	}
}
