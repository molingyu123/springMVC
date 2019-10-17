package com.lingyun.factory;

import com.lingyun.service.IAccountService;
import com.lingyun.service.impl.IAccountServiceImpl;

/**
 *  模拟一个工厂类,(该类可能时存在于jar 包中的，我们无法通过修改源码的方式来提供默认的构造函数)
 */
public class StaticFactory {
//    模拟第二种创建bean 对象方式
    public static IAccountService getAccountSrevice(){
        return  new IAccountServiceImpl();
    }
}
