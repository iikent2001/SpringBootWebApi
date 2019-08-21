package com.example.demo.vo;

import java.sql.Timestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.example.demo.annotation.ChkRePwd;

@ChkRePwd.List({
	@ChkRePwd(field = "password", fieldMatch = "cPassword" ,message="Password don't match")
	
})
public class UserVo {
	
	private Long userid;
	@NotBlank(message = "name is empty")
	private String name;
	@Email
	@NotBlank(message = "email is empty")
	private String email;
	@NotBlank(message = "password is empty")
	private String password;
	@NotBlank(message = "cPassword is empty")
	private String cPassword;
	private String token;
	private Timestamp createDay;
	private Timestamp updateDay; 
	private int number;
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
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getcPassword() {
		return cPassword;
	}
	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
