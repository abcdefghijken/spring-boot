package com.ken.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // add all related advices for logging
    // start with @Before advice

    // run before target object method addAccount()
//    @Before("execution(public void add*())") // exec: pointcut expression
    @Before("execution(* com.ken.aopdemo.dao.*.*(..))") // exec: pointcut expression
    public void beforeAddAccountAdvice() { // can be any method name
        // add custsom code
        System.out.println("\n========>>> Executing @Before Advice on method!");
    }
}
