package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.ThreadsForm;
import com.example.demo.model.ThreadsRepos;
import com.example.demo.model.Users;
import com.example.demo.model.UsersRepos;
import com.google.gson.Gson;
import com.example.demo.SessionModel;
import com.example.demo.model.Categories;
import com.example.demo.model.CategoriesRepos;
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
	private SessionModel sessionModel;
	@Autowired
	private CategoriesRepos categoriesRepos;
	@Autowired
	private UsersRepos usersRepos;
	
	// show page
	@RequestMapping("/archive")
	public String getArchive(Model model) {
		model.addAttribute("user_name", sessionModel.getUserName());//ユーザーネーム表示
		return "PEch/archive";
	}
	
	@RequestMapping("/createThread")
	public String createThread(Model model, CreateThreadForm createThreadForm) {
		Users user = usersRepos.findByUserId( sessionModel.getUserId() );
		//スレッド作成
		Threads thread = new Threads();
		if(categoriesRepos.findByCategoryNameIgnoreCase( createThreadForm.getNewCategory() ) != null) {
			return getArchive(model);
		}
		if(createThreadForm.getCategoryId() == -1) {
			Categories category = createCategory( createThreadForm.getNewCategory() );
			thread.setCategories( category );
			
		}else {
			thread.setCategories( categoriesRepos.findById( createThreadForm.getCategoryId() ).get() );
		}
		
		thread.setThreadName( createThreadForm.getThreadName() );
		thread.setUsers( user );
		thread = threadsRepos.save(thread);
		//1レス投稿
		Reses res = new Reses();
		res.setIsOpenName( createThreadForm.getIsOpenName() );
		res.setRes( createThreadForm.getRes() );
		res.setThreads( thread );
		res.setUsers( user );
		resesRepos.save( res );
		model.addAttribute("threads", thread);
		return "PEch/thread";
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
	
	@RequestMapping(value = "searchThreads", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			method = RequestMethod.GET)
	@ResponseBody
	public String searchThreads(@RequestParam("searchWord") String searchWord,
								@RequestParam("category") Integer category) {
		System.out.println(searchWord);
		System.out.println(category);
		List<Threads> threads = new ArrayList<>();
		
		if(category == null && searchWord.isEmpty()) {
			return getTreads();
		}
		if(category != null && searchWord.isEmpty()) {
			Categories cate = categoriesRepos.findById(category).get();
			threads.addAll(threadsRepos.findByCategories(cate));
		}
		if(category == null && !searchWord.isEmpty()) {
			threads.addAll(threadsRepos.findByThreadNameContaining(searchWord));
		}
		
		if(category != null && !searchWord.isEmpty()) {
			Categories cate = categoriesRepos.findById(category).get();
			threads.addAll(threadsRepos.findByThreadNameContaining(searchWord));
			int size = threads.size();
			for(int i = 0; i < size; i++) {
				if(!threads.get(i).getCategories().equals(cate)) {
					threads.remove(i);
					i--;
					size--;
				}
			}
		}
		return new Gson().toJson(threads);
	}
	
	@RequestMapping(value = "getCategories", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			method = RequestMethod.GET)
	@ResponseBody
	public String getCategories() {
		List<Categories> categories = categoriesRepos.findAll();
		return new Gson().toJson(categories);
	}
	
	public Categories createCategory(String categoryName) {
		Categories category = new Categories();
		category.setCategoryName(categoryName);
		return categoriesRepos.save(category);
	}
}
