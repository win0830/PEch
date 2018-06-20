package com.example.demo.model;

import java.io.Serializable;

public class ResesForm implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String res;
	private Integer threadId;
	private Integer isOpenName = 0;
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	public Integer getThreadId() {
		return threadId;
	}
	public void setThreadId(Integer threadId) {
		this.threadId = threadId;
	}
	public Integer getIsOpenName() {
		return isOpenName;
	}
	public void setIsOpenName(Integer isOpenName) {
		this.isOpenName = isOpenName;
	}
	
	
}
