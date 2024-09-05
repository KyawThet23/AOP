package com.kth.demo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @After("execution(* com.kth.demo.Service.doSomething(..))")
    public void logAfterMethodExecution() {
        System.out.println("Log: After Method doSomething() has been executed.");
    }

    @Before("execution(* com.kth.demo.Service.doSomething(..))")
    public void logBeforeMethodExecution() {
        System.out.println("Log: Before Method doSomething() has been executed.");
    }

    @AfterReturning(pointcut = "execution(* com.example.demo.service.MyService.doSomething(..))", returning = "result")
    public void afterReturningAdvice(Object result) {
        System.out.println("AfterReturning Advice: Method doSomething() returned with value: " + result);
    }

}
