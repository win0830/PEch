package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Threads {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer threadId;
	
	@NotNull
	private String threadName;
	
	@NotNull
	private LocalDateTime createdDate = LocalDateTime.now();
	
	@NotNull
	@ManyToOne
	private Categories categories;
	
	@NotNull
	@ManyToOne
	private Users users;

	@NotNull
	@OneToMany
	private List<Reses> reses;
	
	public Integer getThreadId() {
		return threadId;
	}

	public void setThreadId(Integer threadId) {
		this.threadId = threadId;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public List<Reses> getReses() {
		return reses;
	}

	public void setReses(List<Reses> reses) {
		this.reses = reses;
	}
}
