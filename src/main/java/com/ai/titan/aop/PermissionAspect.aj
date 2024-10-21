package com.ai.titan.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public aspect PermissionAspect {

    @Before("@annotation(Permission)")
    public Object permissionVerfy(ProceedingJoinPoint joinPoint) throws Throwable {

        //获取目标对象
        Object target = joinPoint.getTarget();
        //获取目标对象方法
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = target.getClass().getMethod(
                methodSignature.getName(),
                methodSignature.getParameterTypes());
        Permission annotation = methodSignature.getMethod().getAnnotation(Permission.class);

        System.out.println(annotation.value());
        Permission log = method.getAnnotation(Permission.class);

        //我要检查权限
        System.out.println("我要检查权限" + log.value());

        Object proceed = joinPoint.proceed();

        return proceed;
    }
}
