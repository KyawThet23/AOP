package com.kth.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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

    @AfterThrowing(pointcut = "execution(* com.example.demo.service.MyService.doSomething(..))", throwing = "exception")
    public void afterThrowingAdvice(Exception exception) {
        System.out.println("AfterThrowing Advice: An exception has been thrown: " + exception.getMessage());
    }

    @Around("execution(* com.example.demo.service.MyService.doSomething(..))")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around Advice (Before): Before method execution.");
        Object result = proceedingJoinPoint.proceed(); // Proceed to the target method
        System.out.println("Around Advice (After): After method execution.");
        return result;
    }



}
