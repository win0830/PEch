package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArchiveController {

	@RequestMapping("/archive")
	public String getArchive() {
		return "archive";
	}
}
