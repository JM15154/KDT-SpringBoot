package com.example.dto;



public class LoginDTO {
	String userid;
	String passwd;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public LoginDTO() {
		// TODO Auto-generated constructor stub
	}
	public LoginDTO(String userid, String passwd) {
		this.userid = userid;
		this.passwd = passwd;
	}
	
	
}
