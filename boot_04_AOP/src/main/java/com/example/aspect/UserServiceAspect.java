package com.example.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// UserService에 부가기능 추가하는 빈

@Component
@Aspect
public class UserServiceAspect {
	
	@Pointcut("execution(public String sayHello())")
	public void xxx() {}
	
	@Pointcut("execution(public String callHello())")
	public void xxx2() {}
	
	// Before Advice
	@Before("xxx()")
	public void method() {
		System.out.println("UserServiceAspect.before 어드바이스");
	}
	// After Advice
	@After("execution(public String sayHello())")
	public void method2(JoinPoint point) {
		System.out.println("호출 메서드 = " + point.getSignature().getName());
		System.out.println("UserServiceAspect.after 어드바이스");
	}
	
	// AfterReturning Advice
	// 핵심메서드가 실행돼서 정상적으로 실행결과값을 리턴했을 때 위빙된다. 
	// Aspect에서 핵심메서드가 리턴하는 리턴값을 얻을 수 있다.
	@AfterReturning(pointcut = "execution(public String callHello())", returning ="yyy" )
	public void method3(Object yyy) {
		
		System.out.println("UserServiceAspect.AfterReturning advice" + yyy);
	}
	//AfterThrowing Advice
	// 핵심메서드가 실행돼서 예외 발생시 위빙된다.
	// Aspect에서 핵심메서드가 리턴하는 예외를 얻을 수 있다.
	@AfterThrowing(pointcut = "execution(public String xxx())"   ,throwing = "yyy"  )
	public void method4(Exception yyy) {
		System.out.println("UserServiceAspect.@AfterThrowing advice" + yyy.getMessage());
	}
	// Around Advice
	// 핵심메서드가  실행되기 전, 후 정상적으로 반환, 예외발생시 모두 위빙된다.
	// Aspect에서 핵심메서드가 리턴하는 리턴값 및 예외정보를 얻을 수 있다.
	@Around("execution(public String echoHello())")
	public Object method5 (ProceedingJoinPoint point) throws Throwable {
		System.out.println("Before Advice >>>>>>>>>>>>");
		// 기준 잡기
		Object obj = point.proceed(); // Object가 핵심 메서드의 반환값
		System.out.println("@After Advice >>>>>>>>>>>>");
		System.out.println("@@AfterReturning Advice >>>>>>>>>>>>" + obj);
		return obj;
	}
}
