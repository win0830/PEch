package com.example.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class LoginController {
	
	@RequestMapping("/")
	public String getLogin() {
		return "PEch/login";
	}
	
	
	
	@RequestMapping(value = "", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			method = RequestMethod.GET)
	@ResponseBody
	public String send(@RequestParam("message") String message/*@RequestBody Form form*/) {
		
		return new Gson().toJson("");
	}
}
