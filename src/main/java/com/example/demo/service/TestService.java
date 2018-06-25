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
	
//	public void create() {
//		Users user = new Users();
//		user.setUserId("");
//		user.setPassword("");
//		user.setUserName("");
//		
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
//		t.setThreadName("菫ｺ繧医ｊJava閾ｪ菫｡繝九く縺ｮ繧�縺､縺翫ｋ�ｼ�");
//		t.setCategories(categoriesRepos.findById(1).get());
//		t.setUsers(usersRepos.findById(1).get());
//		threadsRepos.save(t);
//		
//		t = new Threads();
//		t.setThreadName("spring縺ｫ縺､縺�縺ｦ");
//		t.setCategories(categoriesRepos.findById(1).get());
//		t.setUsers(usersRepos.findById(1).get());
//		threadsRepos.save(t);
//
//		
//		t = new Threads();
//		t.setThreadName("谺｡縺ｫ縺上ｋ險�隱�");
//		t.setCategories(categoriesRepos.findById(3).get());
//		t.setUsers(usersRepos.findById(2).get());
//		threadsRepos.save(t);
//
//		
//		t = new Threads();
//		t.setThreadName("cobol縺上◎縺倥ｃ縺ｭ�ｼ�");
//		t.setCategories(categoriesRepos.findById(1).get());
//		t.setUsers(usersRepos.findById(1).get());
//		threadsRepos.save(t);
//
//		
//		t = new Threads();
//		t.setThreadName("譎ゆｻ｣縺ｯ繧�縺｣縺ｱjava");
//		t.setCategories(categoriesRepos.findById(1).get());
//		t.setUsers(usersRepos.findById(3).get());
//		threadsRepos.save(t);
//
//		
//		t = new Threads();
//		t.setThreadName("scala縺檎�ｱ縺�");
//		t.setCategories(categoriesRepos.findById(1).get());
//		t.setUsers(usersRepos.findById(3).get());
//		threadsRepos.save(t);
//
//		
//		t = new Threads();
//		t.setThreadName("swift縺檎�ｱ縺�");
//		t.setCategories(categoriesRepos.findById(1).get());
//		t.setUsers(usersRepos.findById(2).get());
//		threadsRepos.save(t);
//
//		
//		t = new Threads();
//		t.setThreadName("繧ｪ繝悶ず繧ｧ繧ｯ繝�繧｣繝砲縺ｯ蜿､縺�");
//		t.setCategories(categoriesRepos.findById(1).get());
//		t.setUsers(usersRepos.findById(1).get());
//		threadsRepos.save(t);
//
//		
//		t = new Threads();
//		t.setThreadName("SML縺｣縺ｦ遏･縺｣縺ｦ繧具ｼ�");
//		t.setCategories(categoriesRepos.findById(3).get());
//		t.setUsers(usersRepos.findById(1).get());
//		threadsRepos.save(t);
//		
//		t = new Threads();
//		t.setThreadName("matlab縺ｧ鬘碑ｪ崎ｨｼ");
//		t.setCategories(categoriesRepos.findById(3).get());
//		t.setUsers(usersRepos.findById(2).get());
//		threadsRepos.save(t);
//		
//		t = new Threads();
//		t.setThreadName("CNN縺ｯ繝悶Λ繝�繧ｯ繝懊ャ繧ｯ繧ｹ");
//		t.setCategories(categoriesRepos.findById(3).get());
//		t.setUsers(usersRepos.findById(2).get());
//		threadsRepos.save(t);
		
//		Reses res = new Reses();
//		res.setIsOpenName(0);
//		res.setRes("蛻昴Ξ繧ｹ");
//		res.setUsers(usersRepos.findById(1).get());
//		res.setThreads(threadsRepos.findById(2).get());
//		resesRepos.save(res);
//		
//		res = new Reses();
//		res.setIsOpenName(0);
//		res.setRes("蛻昴Ξ繧ｹ");
//		res.setUsers(usersRepos.findById(2).get());
//		res.setThreads(threadsRepos.findById(3).get());
//		resesRepos.save(res);
		
//		Reses res = new Reses();
//		res.setIsOpenName(1);
//		res.setRes("蛻昴Ξ繧ｹ");
//		res.setUsers(usersRepos.findById(1).get());
//		res.setThreads(threadsRepos.findById(10).get());
//		resesRepos.save(res);
//		
//		res = new Reses();
//		res.setIsOpenName(0);
//		res.setRes("繧ｭ繝ｳ繧ｰ縺九↑繝ｼ繧�縺｣縺ｱ繧奇ｽ暦ｽ苓�ｪ蛻�縺ｯ諤昴ｏ縺ｪ縺�繧薙□縺代←蜻ｨ繧翫↓繧ｭ繝ｳ繧ｰ縺｣縺ｦ繧医￥險�繧上ｌ繧具ｽ暦ｽ暦ｽ励％縺ｪ縺�縺��ｼｫ�ｼｭ�ｼｫ�ｼｮ�ｼｧ縺ｫ隱ｲ鬘悟�ｺ縺輔ｌ縺滓凾繧よｰ励′縺､縺�縺溘ｉ諢剰ｭ倡┌縺上※繝励Ο繧ｰ繝ｩ繝�縺悟ｮ梧�舌＠縺ｦ縺溘＠縺ｪ�ｽ暦ｽ暦ｽ励■縺ｪ縺ｿ縺ｫ蠖ｼ螂ｳ縺ｯ逾樒ｵｵ蟶ｫ(閨槭＞縺ｦ縺ｪ縺�ｽ�)");
//		res.setUsers(usersRepos.findById(3).get());
//		res.setThreads(threadsRepos.findById(1).get());
//		resesRepos.save(res);
//		
//		res = new Reses();
//		res.setIsOpenName(1);
//		res.setRes("蛻昴Ξ繧ｹ");
//		res.setUsers(usersRepos.findById(1).get());
//		res.setThreads(threadsRepos.findById(11).get());
//		resesRepos.save(res);
//	
//	}
}
