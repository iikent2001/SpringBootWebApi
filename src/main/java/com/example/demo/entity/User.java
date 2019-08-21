package com.example.demo.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long userid;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String email;
	@CreationTimestamp
	@Column(nullable = false,updatable = false)
	private Timestamp createDay;
	@UpdateTimestamp
	private Timestamp updateDay;
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
