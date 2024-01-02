package com.example.controller;


import java.io.File;
import java.io.IOException;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.dto.UploadDTO;


@Controller
public class TestController {
	
	
	// http://localhost:8090/app/main
	@GetMapping("/uploadForm")
	public String home () {
		return "uploadForm";
	}
	
	@PostMapping("/upload")
	public String upload(UploadDTO dto, Model m) {
		
		String theText = dto.getTheText();
		MultipartFile theFile = dto.getTheFile();
		System.out.println(theText + theFile);
		
		
		String contentType = theFile.getContentType();
		String name = theFile.getName();
		String originalFilename = theFile.getOriginalFilename();
		long size = theFile.getSize();
		
		System.out.println(contentType);
		System.out.println(name);
		System.out.println(originalFilename);
		System.out.println(size);
		// 업로드된 파일의 서버의 물리적인 디렉토리에 저장. c:\\upload
		
		File f = new File("C:\\upload", originalFilename);
		
		try {
			theFile.transferTo(f);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.addAttribute("contentType", contentType);
		m.addAttribute("originalFilename", originalFilename);
		m.addAttribute("size", size);
		
		
		
		return "uploadInfo";
	}
}
 