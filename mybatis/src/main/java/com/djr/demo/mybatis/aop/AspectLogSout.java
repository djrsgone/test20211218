package com.djr.demo.mybatis.aop;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class AspectLogSout {

    @SneakyThrows
    @Around("execution(* com.djr.demo.mybatis.service.impl..*.*(..))")
    public Object printLogTimeOfService(ProceedingJoinPoint joinPoint){

        long st = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long et = System.currentTimeMillis();
        long execTime = et - st;

        if(execTime > 3000){
            log.error("Long Time = {}", execTime);
        }else{
            log.info("Eclipsed Time = {}", execTime);
        }
        return result;
    }
}
