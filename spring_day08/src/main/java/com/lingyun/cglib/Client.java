package com.lingyun.cglib;

import com.lingyun.proxy.IProducer;
import com.lingyun.proxy.Producer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

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
         *          涉及的类Enhancer
         *          提供者，第三方cglib库
         *
         *    基于接口的动态代理：
         *       涉及的类：Proxy
         *       提供者：jdk官方
         *  如何创建代理对象：
         *      使用Enhancer 类中的create方法
         *  创建代理类的要求
         *    被代理类不能是最终类
         * create方法参数：
         *   Class :字节码
         *     它是用于指定被代理对象的字节码
         *   callback:用于增强的代码我们一般写的都是该接口的子接口的实现类MethodInterceptor
         *
         *
         */
      Producer producer1=(Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 执行本地代理对象的任何方法都会经过该方法
             * @param proxy
             * @param method
             * @param args
             * 以上的三个参数和基于接口的动态代理中invoke方法的参数是一样的
             * @param methodProxy 当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            public Object intercept(Object proxy, Method method,
                                    Object[] args, MethodProxy methodProxy) throws Throwable {
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
      producer1.saleProduct(1200F);

    }
}
