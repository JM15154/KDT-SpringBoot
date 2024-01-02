package com.example;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.dto.DeptDTO;
import com.example.exception.DuplicatedDeptnoException;
import com.example.service.DeptService;



@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =SpringApplication.run(DemoApplication.class, args);
		
		DeptService service = ctx.getBean("service",DeptService.class);
		
Scanner scan = new Scanner(System.in);

		
		while(true) {
			System.out.println("부서 관리");
			System.out.println("1. 부서 목록 보기");
			System.out.println("2. 부서 등록");
			System.out.println("3. 부서 수정");
			System.out.println("4. 부서 삭제");
			System.out.println("0. 종료");
			String num = scan.next();
			if("1".equals(num)) {
				List<DeptDTO> list = service.findAll();
				for (DeptDTO dto : list) {
					System.out.println(dto);
				}
				
				
		}else if ("2".equals(num)) {
			System.out.println("부서번호를 입력하시오(중복주의");
			int deptno = scan.nextInt();
			System.out.println("부서명 입력하시오");
			String dname = scan.next();
			System.out.println("부서위치 입력하시오");
			String loc = scan.next();
			
			DeptDTO dto = new DeptDTO(deptno, dname, loc);
			int n = 0;
			try {
				n = service.save(dto);
			} catch (DuplicatedDeptnoException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			System.out.println(n + " 개가 저장되었습니다.");
			
		}else if ("3".equals(num)) {
			System.out.println("수정할 부서번호를 입력하시오");
			int deptno = scan.nextInt();
			System.out.println("수정할 부서명을 입력하시오");
			String dname = scan.next();
			System.out.println("수정할 부서위치를 입력하시오");
			String loc = scan.next();
			
			DeptDTO dto = new DeptDTO(deptno, dname, loc);
			int n = service.update(dto);
			System.out.println(n + " 개가 저장되었습니다.");
			
		}else if ("4".equals(num)) {
			System.out.println("삭제할 부서번호를 입력하시오");
			int deptno = scan.nextInt();
			
			int n = service.remove(deptno);
			
			System.out.println(n + " 개가 삭제 되었습니다.");
		}
		else if ("0".equals(num)) {
			System.out.println("프로그램 종료");
			System.exit(0);
		}
		
	}

}
}