package com.example;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.service.DeptServiceImpl;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		
		
//		String mesg = ctx.getMessage("greet", new String [] {"하이~~","ㅁㄴㅇ"}, Locale.CHINA);
//		System.out.println(mesg);
		
		DeptServiceImpl service = ctx.getBean("xxx", DeptServiceImpl.class);
		System.out.println(service.getMesg());
	}

}
