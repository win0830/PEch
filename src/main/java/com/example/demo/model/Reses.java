package com.example.demo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Reses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer resId;
	
	@NotNull
	private String res;
	
	@NotNull
	private LocalDateTime postTime = LocalDateTime.now();
	
	@NotNull
	private Integer isOpenName = 0;
	
	@NotNull
	@ManyToOne
	private Threads threads;
	
	@NotNull
	@ManyToOne
	private Users users;

	public Integer getResId() {
		return resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
	}

	public String getRes() {
		return res;
	}

	public void setRes(String res) {
		this.res = res;
	}

	public LocalDateTime getPostTime() {
		return postTime;
	}

	public void setPostTime(LocalDateTime postTime) {
		this.postTime = postTime;
	}

	public Integer getIsOpenName() {
		return isOpenName;
	}

	public void setIsOpenName(Integer isOpenName) {
		this.isOpenName = isOpenName;
	}

	public Threads getThreads() {
		return threads;
	}

	public void setThreads(Threads threads) {
		this.threads = threads;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
}
