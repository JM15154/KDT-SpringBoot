package com.example.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.LoginDTO;

@Controller
public class TestController {

	@Autowired
	ServletContext application;
	
	
	@GetMapping("/main")
	public String main() {
		return "main";
	}
	
	@GetMapping("/main2")
	public String main2 (Model m, HttpSession session) {
		
		// request scope
		m.addAttribute("username", "홍길동");
		
		// session scope
		session.setAttribute("username2", "이순신");
		
		// application scope
		application.setAttribute("username3", "유관순");
		
		return "main2";
	}
	
	@GetMapping("/main3")
	public String main3(Model m) {
		m.addAttribute("login",new LoginDTO("홍길동","122"));
		
		return "main3";
	}
	
	@GetMapping("/main4")
	public String main4 (Model m, HttpSession session) {
		
		//1. 조건문
		m.addAttribute("username", "홍길동");
		
		//2. switch 문
		m.addAttribute("login",new LoginDTO("홍길동","122"));
		
		//3. for 문
		List<LoginDTO> list =
				Arrays.asList(new LoginDTO("홍길동", "122"),
						new LoginDTO("홍길동2", "122123"),
						new LoginDTO("홍길동3", "1212321312"));
		m.addAttribute("list",list);
		
		return "main4";
	}
	
	@GetMapping("/main5")
	public String main5() {
		//경로 지정
		return "main5";
	}
	
	@GetMapping("/main5_1")
	public String main5_1() {
		System.out.println("main5_1");
		return "main5_1";
	}
	
	@GetMapping("/main5_2")
	public String main5_2(@RequestParam String id, @RequestParam String pw) {
		System.out.println("main5_2");
		System.out.println(id+pw);
		return "main5_2";
	}
	
	@GetMapping("/main5_3")
	public String main5_3(LoginDTO dto) {
		System.out.println("main5_3" + dto);
		return "main5_3";
	}
	
	@GetMapping("/main6")
	public String main6() {
		return "main6";
	}
}

