package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.SessionModel;
import com.example.demo.model.LoginForm;
import com.example.demo.model.UsersRepos;
import com.example.demo.service.TestService;
import com.google.gson.Gson;

@Controller
public class LoginController {
	
	@Autowired
	private UsersRepos usersRepos;
	
	@Autowired
	private SessionModel sessionModel;
	
	@Autowired
	private TestService service;
	
	//�ｿｽg�ｿｽb�ｿｽv�ｿｽy�ｿｽ[�ｿｽW�ｿｽi�ｿｽ�ｿｽ�ｿｽO�ｿｽC�ｿｽ�ｿｽ�ｿｽy�ｿｽ[�ｿｽW�ｿｽj�ｿｽﾖ費ｿｽﾎゑｿｽ
	@RequestMapping("/")
	public String getLogin() {
//		service.create();
		return "PEch/login";
	}
	
	
	@RequestMapping(value = "", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			method = RequestMethod.GET)
	@ResponseBody
	public String send(@RequestParam("message") String message/*@RequestBody Form form*/) {
		
		return new Gson().toJson("");
	}
	
	
	//�ｿｽ�ｿｽ�ｿｽO�ｿｽC�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾄス�ｿｽ�ｿｽ�ｿｽb�ｿｽh�ｿｽ齬暦ｿｽy�ｿｽ[�ｿｽW�ｿｽ�ｿｽ
	@RequestMapping(value="login")
	public String login(ModelMap model, LoginForm form ,HttpServletRequest req) {
		if(usersRepos.findByUserId(form.getUserId())!=null) { //�ｿｽ�ｿｽ�ｿｽ[�ｿｽU�ｿｽ[�ｿｽh�ｿｽc�ｿｽi�ｿｽ�ｿｽ�ｿｽ[�ｿｽ}�ｿｽ�ｿｽ�ｿｽj�ｿｽﾌ茨ｿｽv�ｿｽ�ｿｽ�ｿｽ驛��ｿｽ[�ｿｽU�ｿｽ[�ｿｽﾌ鯉ｿｽ�ｿｽ�ｿｽ
			if(usersRepos.findByUserId(form.getUserId()).getPassword()//�ｿｽ�ｿｽv�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ[�ｿｽU�ｿｽ[�ｿｽﾆパ�ｿｽX�ｿｽ�ｿｽ�ｿｽ[�ｿｽh�ｿｽ�ｿｽ�ｿｽ�ｿｽv�ｿｽ�ｿｽ�ｿｽ驍ｩ�ｿｽﾇゑｿｽ�ｿｽ�ｿｽ
					.equals(form.getPassword())) {
				sessionModel.setUserName(usersRepos.findByUserId(form.getUserId()).getUserName());//�ｿｽZ�ｿｽb�ｿｽV�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾉ�ｿｽ�ｿｽ[�ｿｽU�ｿｽ[�ｿｽl�ｿｽ[�ｿｽ�ｿｽ�ｿｽi�ｿｽ�ｿｽ�ｿｽ{�ｿｽ�ｿｽj�ｿｽZ�ｿｽb�ｿｽg
				model.addAttribute("username",usersRepos.findByUserId(form.getUserId()).getUserName());//�ｿｽ�ｿｽ�ｿｽf�ｿｽ�ｿｽ�ｿｽﾉ�ｿｽ�ｿｽ[�ｿｽU�ｿｽ[�ｿｽl�ｿｽ[�ｿｽ�ｿｽ�ｿｽﾌセ�ｿｽb�ｿｽg
<<<<<<< HEAD
				model.addAttribute("user_name", sessionModel.getUserName());//ユーザーネーム表示
=======
				sessionModel.setUserId(usersRepos.findByUserId(form.getUserId()).getUserId());
>>>>>>> refs/remotes/origin/master
				return "PEch/archive";
			}
		}
		//�ｿｽ�ｿｽ�ｿｽO�ｿｽC�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽs�ｿｽ�ｿｽ�ｿｽF�ｿｽ�ｿｽ�ｿｽs�ｿｽt�ｿｽ�ｿｽ�ｿｽO�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾄて�ｿｽ�ｿｽ[�ｿｽU�ｿｽ[�ｿｽh�ｿｽc�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽZ�ｿｽb�ｿｽg�ｿｽ�ｿｽ�ｿｽﾄ�ｿｽ�ｿｽO�ｿｽC�ｿｽ�ｿｽ�ｿｽ�ｿｽﾊゑｿｽ
		model.addAttribute("flag", true);
		model.addAttribute("userId", form.getUserId());
		model.addAttribute("user_name", sessionModel.getUserName());//ユーザーネーム表示
		return "PEch/login";
	}
	
	//�ｿｽ�ｿｽ�ｿｽO�ｿｽA�ｿｽE�ｿｽg�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾄ�ｿｽ�ｿｽO�ｿｽC�ｿｽ�ｿｽ�ｿｽy�ｿｽ[�ｿｽW�ｿｽ�ｿｽ
	@RequestMapping("logout")
	public String logout(Model m) {
		sessionModel.setUserName(null);
		sessionModel.setUserId(null);
		return "PEch/login";
	}
	
	
	
}
