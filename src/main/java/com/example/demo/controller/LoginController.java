package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.SessionModel;
import com.example.demo.model.LoginForm;
import com.example.demo.model.UsersRepos;
import com.google.gson.Gson;

@Controller
public class LoginController {
	
	@Autowired
	private UsersRepos usersRepos;
	
	@Autowired
	private SessionModel sessionModel;
	
	//トップページ（ログインページ）へ飛ばす
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
	
	
	//ログイン処理してスレッド一覧ページへ
	@RequestMapping(value="login")
	public String login(ModelMap model, LoginForm form ,HttpServletRequest req) {
		if(usersRepos.findByUserId(form.getUserId())!=null) {
			if(usersRepos.findByUserId(form.getUserId()).getPassword()
					.equals(form.getPassword())) {
				
			}
		}
		return "PEch/archive";
	}
}
