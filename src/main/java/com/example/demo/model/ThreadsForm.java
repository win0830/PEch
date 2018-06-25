package com.example.demo.model;

import java.io.Serializable;

public class ThreadsForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer threadId;
	private Integer page;
	private Integer threadsCount;
	private String serchWord;
	private String category;
	
	public Integer getThreadId() {
		return threadId;
	}
	public void setThreadId(Integer threadId) {
		this.threadId = threadId;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getThreadsCount() {
		return threadsCount;
	}
	public void setThreadsCount(Integer threadsCount) {
		this.threadsCount = threadsCount;
	}
	public String getSerchWord() {
		return serchWord;
	}
	public void setSerchWord(String serchWord) {
		this.serchWord = serchWord;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
