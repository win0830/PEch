package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

@Controller
public class ThreadController {

	@RequestMapping("/thread")
	public String getTread() {
		return "PEch/thread";
	}
	
	@RequestMapping(value = "sendMessage", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			method = RequestMethod.GET)
	public String sendMessage() {
		return new Gson().toJson("");
	}
}
