package com.example.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dto.LoginDTO;


@Controller
public class TestController {
	
	//ajax.jsp
	@GetMapping("/")
	public String main() {
		
		return "ajax";
	}
	
	@PostMapping("/main")
	public String home (@RequestBody LoginDTO dto) {
		System.out.println("LoginDTO : " + dto);
		return "ajax";
	}
	@PostMapping("/main2")
	public String home2 (@RequestBody ArrayList<LoginDTO> list) {
		System.out.println("ArrayList<LoginDTO> " + list);
		
		
		return "ajax";
	}
}
 