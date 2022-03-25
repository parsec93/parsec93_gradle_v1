package com.parsec93.parsec93_gradle_v1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    //@Around("execution(* com.parsec93.parsec93_gradle_v1.service..*(..))") //서비스만 측정도 가능
    @Around("execution(* com.parsec93.parsec93_gradle_v1..*(..))") //패키지명을 작성하면 됨
    public Object execut(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try {
            Object result = joinPoint.proceed();
            return result;
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }

    }
}
