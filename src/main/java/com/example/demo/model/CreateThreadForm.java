package com.example.demo.model;

import java.io.Serializable;

public class CreateThreadForm implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String threadName;
	
	private String res;
	
	private Integer isOpenName = 0;
	
	private Categories categories;
	
	public String getThreadName() {
		return threadName;
	}
	
	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}
	
	public String getRes() {
		return res;
	}
	
	public void setRes(String res) {
		this.res = res;
	}
	
	public Integer getIsOpenName() {
		return isOpenName;
	}
	
	public void setIsOpenName(Integer isOpenName) {
		this.isOpenName = isOpenName;
	}
	
	public Categories getCategories() {
		return categories;
	}
	
	public void setCategories(Categories categories) {
		this.categories = categories;
	}
	
	
}
