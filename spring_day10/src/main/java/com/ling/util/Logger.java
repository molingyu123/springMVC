package com.ling.util;


import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 用于记录日志的工具类，它里面提供了公共的代码
 */
public class Logger {

    /**
     * 前置通知
     */
    public void beforePrintLog(){
        System.out.println("前置通知beforePrintLog.....");
    }

    /**
     * 后置通知
     */
    public void afterPrintLog(){
        System.out.println("后置通知afterPrintLog.....");
    }

    /**
     * 异常通知
     */
    public void afterThrowPrintLog(){
        System.out.println("异常通知afterThrowPrintLog.....");
    }

    /**
     * 最终通知
     */
    public void overPrintLOg(){
        System.out.println("最终通知overPrintLOg.....");
    }

    /**
     * 环绕通知
     *   问题:当我们配置环绕通知之后,切入点方法未执行，而环绕通知方法执行了
     *   分析：通过对比动态代理中的环绕通知代码，发现动态动态代理的环绕通知有明确的切入点方法调用，而我们的代码中没有
     *   解决:spring 为我们提供了一个接口ProceedingJoinPoint 该接口有个方法proceed() 此方法就相当于明确调用切入点方法
     *        该接口可以作为环绕通知的方法参数，在程序执行时，spring 框架会为我们提供该接口的实现类供我们使用
     *
     *   spring 中的环绕通知：
     *     它是spring 框架为我们提供的一种可以在代码种手动控制增强方法何时执行的方式
     */
    public Object aroundPrintLog(ProceedingJoinPoint proceedingJoinPoint){
        Object returnValue="";
        try {
            Object [] args = proceedingJoinPoint.getArgs();// 得到方法所需的参数

            System.out.println("环绕通知---前置通知执行了.....");//写在proceed()方法前 表明这个是前置通知

            returnValue=proceedingJoinPoint.proceed();

            System.out.println("环绕通知---后置通知执行了.....");//写在proceed()方法后 表明这个是后置通知
            return returnValue;
        }catch (Throwable t){
            System.out.println("环绕通知---异常通知执行了.....");//写在异常中 表明这个是异常通知
            throw new RuntimeException(t);
        }finally {
            System.out.println("环绕通知--最终通知执行了.....");//写在finally方法 表明这个是最终通知
        }


    }
}
