package com.ken.aopdemo.aspect;

import com.ken.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.ken.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint pjp) throws Throwable {

        // print out method we are advising on
        String method = pjp.getSignature().toShortString();
        System.out.println("\n=====> Executing @Around on method: " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // execute method
        Object result = null;

        try {
            pjp.proceed();
        } catch (Exception exc) {
            // log exception
            System.out.println(exc.getMessage());

            throw exc;
        }

        // get end timestamp
        long end = System.currentTimeMillis();

        long duration = end - begin;

        System.out.println("\n======> Duration: " + duration/1000.0 + " seconds");

        return result;
    }

    @After("execution(* com.ken.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFindAccountsAdvice(JoinPoint jp) {
        // which method we are advising on
        String method = jp.getSignature().toShortString();
        System.out.println("\n=====> Executing @After on method: " + method);
    }

    @AfterThrowing(pointcut = "execution(* com.ken.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "exc")
    public void afterThrowingFindAccountsAdvice(JoinPoint jp, Throwable exc) {
        // which method we are advising on
        String method = jp.getSignature().toShortString();
        System.out.println("\n=====> Executing @AfterThrowing on method: " + method);

        System.out.println("\n=====> Exception is: " + exc);
    }

    @AfterReturning(pointcut = "execution(* com.ken.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint jp, List<Account> result) {
        // which method we are advising on
        String method = jp.getSignature().toShortString();
        System.out.println("\n=====> Executing @AfterReturning on method: " + method);

        // print results of method call
        System.out.println("\n=====> Result is : " + result);

        // post-process the data, modify and convert account name to uppercase.
        convertAccountNamesToUpperCase(result);
        System.out.println("\n=====> Result is : " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        for (Account temp: result) {
            temp.setName(temp.getName().toUpperCase(Locale.ROOT));
        }
    }

    @Before("com.ken.aopdemo.aspect.AopExpressions.forDaoPackageNoSetterAndGetter()")
    public void beforeAddAccountAdvice(JoinPoint jp) {
        System.out.println("\n========>>> Executing @Before Advice on method!");

        // Method Signature
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        System.out.println("==== Method Signature: " + methodSignature);

        // Actual Params Passed
        Object[] args = jp.getArgs();
        for (Object temp: args) {
            System.out.println(temp);

            if (temp instanceof Account) {
                // downcast and print Account specific stuff
                Account account = (Account) temp;
                System.out.println("== Account Name: " + account.getName());
                System.out.println("== Service Level: " + account.getLevel());
            }
        }
    }
}
