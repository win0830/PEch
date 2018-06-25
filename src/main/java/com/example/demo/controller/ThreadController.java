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
import com.example.demo.model.ThreadsForm;
import com.google.gson.Gson;

@Controller
public class ThreadController {
	@Autowired
	private ResesRepos resesRepos;
	@Autowired
	private SessionModel sessionModel;
	
	@RequestMapping("/thread")
	public String getTread(Model model) {
		model.addAttribute("user_name", sessionModel.getUserName());//ユーザーネーム表示
		return "PEch/thread";
	}
	
	@RequestMapping(value = "sendMessage", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			method = RequestMethod.GET)
	public String sendMessage() {
		return new Gson().toJson("");
	}
	
	// show res all 
	@RequestMapping(value="/getReses",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
    @ResponseBody
	public String getReses(@RequestBody ResesForm resesForm) {
		List<Reses> reses = new ArrayList<Reses>();
		for(Reses res : resesRepos.findAll()) {
			if(res.getThreads().getThreadId() == resesForm.getThreadId()) {
				reses.add(res);
			}
		}
		return new Gson().toJson(reses);
	}
}
