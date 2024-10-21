package com.ai.titan.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LogAspect {

//    @Before("execution(public Integer com.ai.demo.aop.Call.*(..))")
    public void before(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("开始调用"+ name+"请求参数是"+ Arrays.toString(joinPoint.getArgs()));
    }

//    @AfterReturning(value = "execution(public Integer com.example.demo.aop.Call.*(..))",returning = "res")
    public void AfterReturning(JoinPoint joinPoint, Object res) {
        String name = joinPoint.getSignature().getName();
        System.out.println("执行完成"+ name+"结果数是"+ res.toString());
    }
}
