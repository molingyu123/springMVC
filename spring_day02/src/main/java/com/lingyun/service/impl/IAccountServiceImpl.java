package com.lingyun.service.impl;

import com.lingyun.service.IAccountService;

public class IAccountServiceImpl implements IAccountService {


//    public IAccountServiceImpl(String name){
//        System.out.println("测试");
//    }

//    public IAccountServiceImpl(){
//        System.out.println("对象创建了");
//    }

    public  void IAccountService() {
        System.out.println("业务层处理数据");
    }

    public void init(){
        System.out.println("对象初始化了");
    }

    public void destroy(){
        System.out.println("对象销毁了");
    }
}
