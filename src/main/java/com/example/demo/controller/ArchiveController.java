package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.CreateThreadForm;

@Controller
public class ArchiveController {

	@RequestMapping("/archive")
	public String getArchive() {
		return "PEch/archive";
	}
	
	@RequestMapping("/createThread")
	public String createThread(CreateThreadForm createThreadForm) {
		
		return "PEch/archive";
	}
}
