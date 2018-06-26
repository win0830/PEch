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

import com.example.demo.SessionModel;
import com.example.demo.model.Reses;
import com.example.demo.model.ResesForm;
import com.example.demo.model.ResesRepos;
import com.example.demo.model.Threads;
import com.example.demo.model.ThreadsRepos;
import com.example.demo.model.Users;
import com.example.demo.model.UsersRepos;
import com.google.gson.Gson;

@Controller
public class ThreadController {
	@Autowired
	private ThreadsRepos threadsRepos;
	@Autowired
	private ResesRepos resesRepos;
	@Autowired
	private SessionModel sessionModel;
	@Autowired
	private UsersRepos usersRepos;
	
	@RequestMapping("/thread")
	public String getTread(ResesForm form, Model model) {
		model.addAttribute("user_name", sessionModel.getUserName());//ユーザーネーム表示
		System.out.println(form.getThreadId());
		return "PEch/thread";
	}
	
	@RequestMapping(value = "/getThreadInfo", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			method = RequestMethod.GET)
	@ResponseBody
	public String getThreadInfo() {
		
		return new Gson().toJson("");
	}
	
	// レス投稿
	@RequestMapping(value = "sendMessage", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			method = RequestMethod.GET)
	@ResponseBody
	public String sendMessage(@RequestBody ResesForm resesForm) {
		Threads threads = threadsRepos.findById( resesForm.getThreadId() ).get();
		Reses res = new Reses();
		res.setIsOpenName( resesForm.getIsOpenName() );
		res.setRes( resesForm.getRes() );
		res.setThreads( threads );
		res.setUsers( usersRepos.findByUserId( sessionModel.getUserId() ) );
		resesRepos.save(res);
		// ここでレス数をカウントする
		Integer i = threads.getResesCount()+1;
		threads.setResesCount(i);
		threadsRepos.save(threads);
		return new Gson().toJson("");
	}
	
	// show res all 
	@RequestMapping(value="/getReses",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.GET)
    @ResponseBody
	public String getReses(@RequestBody ResesForm resesForm) {
		List<Reses> reses = new ArrayList<Reses>();
		for(Reses res : resesRepos.findAll(new Sort(Sort.Direction.ASC,"postTime"))) {
			if(res.getThreads().getThreadId() == resesForm.getThreadId()) {
				reses.add(res);
			}
		}
		return new Gson().toJson(reses);
	}
}
