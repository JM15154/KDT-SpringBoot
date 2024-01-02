package com.example.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service("xxx")
public class DeptServiceImpl {
	
	
	@Autowired
	MessageSource ctx;
	
	
	public String getMesg() {
		
		String mesg = ctx.getMessage("greet", new String [] {"하이~~","ㅁㄴㅇ"}, Locale.CHINA);
		System.out.println(mesg);
		
		return "hello";
	}
}
