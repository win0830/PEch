package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.TestService;

@Controller
public class NewThreadController {

	@RequestMapping("/newThread")
	public String getNewThread() {
		return "newThread";
	}
	
}
