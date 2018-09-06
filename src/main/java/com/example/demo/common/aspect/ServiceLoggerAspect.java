package com.example.demo.common.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

/**
 * 定义Spring AOP 切面工程
 * 切面工程有几个
 * Before：在方法被调用之前调用
 * After：在方法完成之前调用，无论方法是否执行成功
 * After-returning：在方法执行成功之后调用
 * After-throwing：在方法抛出异常调用
 * Around：环绕通知
 */
@Aspect
@Configuration
public class ServiceLoggerAspect {

    // 定义Service切点
    ///匹配com.example.demo.User.service 包及其子包中所有类中的所有方法，返回类型任意，方法参数任意
    @Pointcut("execution(* com.example.demo.User.service..*.*(..))")
    public void serviceAspect(){

    }

    // 方法调用之前调用日志记录
    @Before("serviceAspect()")
    public void doBeforeService(JoinPoint joinpoint){
        System.out.println("ServiceLoggerAspect.doBeforeService -- > 方法调用之前调用日志");
        String className = joinpoint.getTarget().getClass().getName();
        String method = joinpoint.getSignature().getName();
        System.out.println("该方法存在的类名： -- > "+className);
        System.out.println("该方法的名称： -- > " + method);
        Object[] args = joinpoint.getArgs();
        if (args != null && args.length > 0) {
            String info = StringUtils.join(args, ";");
            System.out.println("该方法的传递过来的参数： -- > "+info);
        }

    }

    @AfterReturning(value = "serviceAspect()",returning = "returnVal")
    public void doAfterReturning(JoinPoint joinpoint,Object returnVal){
        System.out.println("ServiceLoggerAspect.doAfterReturning -- > 方法调用成功之后调用日志");
        System.out.println("返回的参数 -- > "+returnVal);
    }

    @AfterThrowing(value = "serviceAspect()",throwing = "throwable")
    public void doAfterThowing(JoinPoint joinpoint,Throwable throwable){
        System.out.println("ServiceLoggerAspect.doAfterThrowing -- > 方法出现异常调用日志");
        System.out.println("异常消息 -- > "+throwable);
    }

}
