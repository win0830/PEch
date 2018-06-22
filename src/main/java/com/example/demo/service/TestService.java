package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Categories;
import com.example.demo.model.CategoriesRepos;
import com.example.demo.model.Reses;
import com.example.demo.model.ResesRepos;
import com.example.demo.model.Threads;
import com.example.demo.model.ThreadsRepos;
import com.example.demo.model.Users;
import com.example.demo.model.UsersRepos;

@Service
public class TestService {

	@Autowired
	private ThreadsRepos threadsRepos;
	@Autowired
	private UsersRepos usersRepos;
	@Autowired
	private CategoriesRepos categoriesRepos;
	@Autowired
	private ResesRepos resesRepos;
	
	public void create() {
//		Users user = new Users();
//		user.setUserId("");
//		user.setPassword("");
//		user.setUserName("");
		
//		Categories ca = new Categories();
//		ca.setCategoryName("java");
//		categoriesRepos.save(ca);
//		
//		ca = new Categories();
//		ca.setCategoryName("php");
//		categoriesRepos.save(ca);
//		
//		ca = new Categories();
//		ca.setCategoryName("python");
//		categoriesRepos.save(ca);
		
//		Threads t = new Threads();
//		t.setThreadName("俺よりJava自信ニキのやつおる？");
//		t.setCategories(categoriesRepos.findById(1).get());
//		t.setUsers(usersRepos.findById(1).get());
//		threadsRepos.save(t);
//		
//		t = new Threads();
//		t.setThreadName("springについて");
//		t.setCategories(categoriesRepos.findById(1).get());
//		t.setUsers(usersRepos.findById(1).get());
//		threadsRepos.save(t);
//
//		
//		t = new Threads();
//		t.setThreadName("次にくる言語");
//		t.setCategories(categoriesRepos.findById(3).get());
//		t.setUsers(usersRepos.findById(2).get());
//		threadsRepos.save(t);
//
//		
//		t = new Threads();
//		t.setThreadName("cobolくそじゃね？");
//		t.setCategories(categoriesRepos.findById(1).get());
//		t.setUsers(usersRepos.findById(1).get());
//		threadsRepos.save(t);
//
//		
//		t = new Threads();
//		t.setThreadName("時代はやっぱjava");
//		t.setCategories(categoriesRepos.findById(1).get());
//		t.setUsers(usersRepos.findById(3).get());
//		threadsRepos.save(t);
//
//		
//		t = new Threads();
//		t.setThreadName("scalaが熱い");
//		t.setCategories(categoriesRepos.findById(1).get());
//		t.setUsers(usersRepos.findById(3).get());
//		threadsRepos.save(t);
//
//		
//		t = new Threads();
//		t.setThreadName("swiftが熱い");
//		t.setCategories(categoriesRepos.findById(1).get());
//		t.setUsers(usersRepos.findById(2).get());
//		threadsRepos.save(t);
//
//		
//		t = new Threads();
//		t.setThreadName("オブジェクティブCは古い");
//		t.setCategories(categoriesRepos.findById(1).get());
//		t.setUsers(usersRepos.findById(1).get());
//		threadsRepos.save(t);
//
//		
//		t = new Threads();
//		t.setThreadName("SMLって知ってる？");
//		t.setCategories(categoriesRepos.findById(3).get());
//		t.setUsers(usersRepos.findById(1).get());
//		threadsRepos.save(t);
//		
//		t = new Threads();
//		t.setThreadName("matlabで顔認証");
//		t.setCategories(categoriesRepos.findById(3).get());
//		t.setUsers(usersRepos.findById(2).get());
//		threadsRepos.save(t);
//		
//		t = new Threads();
//		t.setThreadName("CNNはブラックボックス");
//		t.setCategories(categoriesRepos.findById(3).get());
//		t.setUsers(usersRepos.findById(2).get());
//		threadsRepos.save(t);
		
//		Reses res = new Reses();
//		res.setIsOpenName(0);
//		res.setRes("初レス");
//		res.setUsers(usersRepos.findById(1).get());
//		res.setThreads(threadsRepos.findById(2).get());
//		resesRepos.save(res);
//		
//		res = new Reses();
//		res.setIsOpenName(0);
//		res.setRes("初レス");
//		res.setUsers(usersRepos.findById(2).get());
//		res.setThreads(threadsRepos.findById(3).get());
//		resesRepos.save(res);
		
		Reses res = new Reses();
		res.setIsOpenName(1);
		res.setRes("初レス");
		res.setUsers(usersRepos.findById(1).get());
		res.setThreads(threadsRepos.findById(10).get());
		resesRepos.save(res);
		
		res = new Reses();
		res.setIsOpenName(0);
		res.setRes("初レス");
		res.setUsers(usersRepos.findById(3).get());
		res.setThreads(threadsRepos.findById(1).get());
		resesRepos.save(res);
		
		res = new Reses();
		res.setIsOpenName(1);
		res.setRes("初レス");
		res.setUsers(usersRepos.findById(1).get());
		res.setThreads(threadsRepos.findById(11).get());
		resesRepos.save(res);
	
	}
}
