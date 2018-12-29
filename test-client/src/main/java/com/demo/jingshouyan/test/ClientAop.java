package com.demo.jingshouyan.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author jingshouyan
 * #date 2018/12/28 20:16
 */
@Aspect
@Component
public class ClientAop {
    @Pointcut("bean(jrpcClient) && execution(* *.handle(..))")
    public void aspect() {
    }
    @Around("aspect()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature)signature;
        Method targetMethod = methodSignature.getMethod();
        System.out.println("classname:" + targetMethod.getDeclaringClass().getName());
        System.out.println("superclass:" + targetMethod.getDeclaringClass().getSuperclass().getName());
        System.out.println("isinterface:" + targetMethod.getDeclaringClass().isInterface());
        System.out.println("target:" + pjp.getTarget().getClass().getName());
        System.out.println("proxy:" + pjp.getThis().getClass().getName());
        System.out.println("method:" + targetMethod.getName());

        return pjp.proceed();
    }
}
