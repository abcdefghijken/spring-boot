package com.ken.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
    @Pointcut("execution(* com.ken.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.ken.aopdemo.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("execution(* com.ken.aopdemo.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("forDaoPackage() && !(setter() || getter())")
    public void forDaoPackageNoSetterAndGetter() {}
}
