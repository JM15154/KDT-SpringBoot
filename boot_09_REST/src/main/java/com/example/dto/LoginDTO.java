package com.example.dto;

public class LoginDTO {

    private String userid;
    private String passwd;

    @Override
   public String toString() {
      return "LoginDTO [userid=" + userid + ", passwd=" + passwd + "]";
   }

   // 기본 생성자
    public LoginDTO() {
    }

    // 매개변수를 받는 생성자
    public LoginDTO(String userid, String passwd) {
        this.userid = userid;
        this.passwd = passwd;
    }

    // userid의 getter 및 setter
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    // passwd의 getter 및 setter
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}