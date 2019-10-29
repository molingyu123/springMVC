package com.lingyun.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟一个消费者
 */
public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();
        /**
         * 动态代理：
         *    特点：字节码随着用随着创建，随用随加载
         *    作用：不修改源码的基础上对方法的增强
         *    分类：
         *       基于接口的动态代理
         *       基于子类的动态代理
         *    基于接口的动态代理：
         *       涉及的类：Proxy
         *       提供者：jdk官方
         *  如何创建代理对象：
         *     使用Proxy 类中newProxyInstance方法
         *  创建代理类的要求
         *    被代理类最少实现一个接口，如果么有则不能使用
         * newProxyInstance方法参数：
         *   ClassLoader:类加载器
         *       它是用于加载代理对象字节码的，和被代理对象使用相同的类加载器--固定写法
         *   Class[]：字节码数组
         *      它是用于让代理对象和被代理对象有相同方法，固定写法
         *   InvocationHandler：用于提供增强的代码
         *      它是让我们写如何代理，我们一般都是写一个该接口的实现类，通常情况下都是匿名内部类
         *      但不是必须，此接口的实现类都是谁用谁写
         *
         */
      IProducer iProducer=(IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
              producer.getClass().getInterfaces(),
              new InvocationHandler() {
          /**
           * 作用：执行被代理对象的任何接口方法都会经过该方法
           * 方法参数的含义
            * @param proxy 代理对象的引用
           * @param method  当前执行的方法
           * @param args  当前执行方法所需的参数
           * @return   和被代理对象有相同的返回值
           * @throws Throwable
           */
          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
              // 提供增强的代码
              Object returnValue =null;
              //1. 获取方法执行的参数
              Float f = (Float)args[0];
              if("saleProduct".equals(method.getName())){
                  returnValue= method.invoke(producer,f*0.8F);
              }
              return returnValue;
            }
        });
        iProducer.saleProduct(1000F);
    }
}
