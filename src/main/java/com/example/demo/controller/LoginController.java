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
	
	//�g�b�v�y�[�W�i���O�C���y�[�W�j�֔�΂�
	@RequestMapping("/")
	public String getLogin() {
		service.create();
		return "PEch/login";
	}
	
	
	@RequestMapping(value = "", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			method = RequestMethod.GET)
	@ResponseBody
	public String send(@RequestParam("message") String message/*@RequestBody Form form*/) {
		
		return new Gson().toJson("");
	}
	
	
	//���O�C���������ăX���b�h�ꗗ�y�[�W��
	@RequestMapping(value="login")
	public String login(ModelMap model, LoginForm form ,HttpServletRequest req) {
		if(usersRepos.findByUserId(form.getUserId())!=null) { //���[�U�[�h�c�i���[�}���j�̈�v���郆�[�U�[�̌���
			if(usersRepos.findByUserId(form.getUserId()).getPassword()//��v�������[�U�[�ƃp�X���[�h����v���邩�ǂ���
					.equals(form.getPassword())) {
				sessionModel.setUserName(usersRepos.findByUserId(form.getUserId()).getUserName());//�Z�b�V�����Ƀ��[�U�[�l�[���i���{��j�Z�b�g
				model.addAttribute("username",usersRepos.findByUserId(form.getUserId()).getUserName());//���f���Ƀ��[�U�[�l�[���̃Z�b�g
				return "PEch/archive";
			}
		}
		//���O�C�����s���F���s�t���O�����Ăă��[�U�[�h�c�����Z�b�g���ă��O�C����ʂ�
		model.addAttribute("flag", true);
		model.addAttribute("userId", form.getUserId());
		return "PEch/login";
	}
	
	//���O�A�E�g�������ă��O�C���y�[�W��
	@RequestMapping("logout")
	public String logout() {
		sessionModel.setUserName(null);
		return "PEch/login";
	}
	
	
	
}
