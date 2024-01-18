package com.vueapi.springboot.cruddemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class Logger {

    @Before("execution(* com.vueapi.springboot.cruddemo.rest.*.*(..))")
    private void logInfo(JoinPoint theJoinPoint){
        System.out.println("theJoinPoint.getKind()===================\n"+ theJoinPoint.getKind());
        System.out.println("theJoinPoint.getSignature()===================\n"+ theJoinPoint.getSignature());
        System.out.println("theJoinPoint.getSourceLocation()===================\n"+ theJoinPoint.getSourceLocation());
        System.out.println("theJoinPoint.getClass()===================\n"+ theJoinPoint.getClass());

    }

    @AfterReturning(pointcut = "execution(* com.vueapi.springboot.cruddemo.rest.*.*(..))", returning = "res")
    private void getResTo(JoinPoint theJoinPoint, ResponseEntity res){
        System.out.println("++++++++++++++++++++++\n");
        System.out.println(res);
        System.out.println("++++++++++++++++++++++\n");
    }

    @AfterThrowing(pointcut = "execution(* com.vueapi.springboot.cruddemo.rest.*.*(..))", throwing = "ex")
    private void getException(JoinPoint theJoinPoint, Throwable ex){
        System.out.println("++++++++++++++++++++++\n");
        System.out.println(ex.getMessage());
        System.out.println("++++++++++++++++++++++\n");
    }


    @After("execution(* com.vueapi.springboot.cruddemo.rest.*.*(..))")
    private void logAfterExecution(JoinPoint theJoinPoint){
        System.out.println("*************************\n");
        System.out.println("After advice (default) called!");
        System.out.println("*************************\n");
    }

    @Around("execution(* com.vueapi.springboot.cruddemo.service.*.*(..))")
    public Object testTime(ProceedingJoinPoint theProJoinPoint) throws Throwable{

        long start = System.currentTimeMillis();

        Object result = theProJoinPoint.proceed();

        long stop = System.currentTimeMillis();

        long duration = stop - start;

        System.out.println("Result:" + duration / 1000.0+ " seconds");
        return result;
    }

    @Around("execution(* com.vueapi.springboot.cruddemo.*.*.*(..))")
    public Object handleExceptions(ProceedingJoinPoint theProJoinPoint) throws Throwable{

        long start = System.currentTimeMillis();
        Object result = null;

        try{
            result = theProJoinPoint.proceed();
        }catch (Throwable ex){
            System.out.println("You have some exception:"+ex.getMessage());
        }


        long stop = System.currentTimeMillis();

        long duration = stop - start;

        System.out.println("Result:" + duration / 1000.0+ " seconds");

        return result;
    }
}
