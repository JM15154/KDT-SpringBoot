package com.example.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.LoginDTO;

import io.swagger.annotations.ApiOperation;

// Rest 서비스

@RestController // @Controller + @ResponseBody
public class TestController {

	@ApiOperation(value = "홍길동 응답")
	@GetMapping("/main6")
	public ResponseEntity<LoginDTO> home6() {

		LoginDTO dto = new LoginDTO("홍길동1", "1234");

		return ResponseEntity.status(HttpStatus.OK).body(dto);
//			return ResponseEntity.ok(dto);
	}

	// http://localhost:8090/app/main5/1/aaa
	@GetMapping("/main5/{num}/{name}")
	public String main5(@PathVariable("num") int num, @PathVariable("name") String name) {
		System.out.println(num + name);
		return "Hello";
	}

	// http://localhost:8090/app/main4/1

	@GetMapping("/main4/{num}")
	public String main4(@PathVariable("num") int num) {
		System.out.println(num);
		return "Hello";
	}

	@GetMapping("/main")
	public String main() {
		return "Hello";
	}

	@GetMapping("/main2")
	public LoginDTO home() {
		LoginDTO dto = new LoginDTO("홍길동1", "1234");
		return dto;
	}

	@GetMapping("/main3")
	public List<LoginDTO> home3() {

		List<LoginDTO> list = Arrays.asList(new LoginDTO("홍길동1", "1234"), new LoginDTO("홍길동2", "1231234"));

		return list;
	}
}
