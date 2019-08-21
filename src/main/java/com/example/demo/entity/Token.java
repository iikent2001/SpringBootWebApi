package com.example.demo.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Token {

	private Long userid;
	private String user;
	private String password;
	
	private Timestamp createDay = Timestamp.valueOf(LocalDateTime.now());
	private Timestamp updateDay = Timestamp.valueOf(LocalDateTime.now());
	
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getCreateDay() {
		return createDay;
	}
	public void setCreateDay(Timestamp createDay) {
		this.createDay = createDay;
	}
	public Timestamp getUpdateDay() {
		return updateDay;
	}
	public void setUpdateDay(Timestamp updateDay) {
		this.updateDay = updateDay;
	}
	
}
