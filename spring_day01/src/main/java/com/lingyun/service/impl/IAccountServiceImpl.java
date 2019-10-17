package com.lingyun.service.impl;

import com.lingyun.dao.IAccountDao;
import com.lingyun.dao.impl.IAccountDaoImpl;
import com.lingyun.service.IAccountService;

public class IAccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new IAccountDaoImpl();

    public IAccountServiceImpl(){
        System.out.println("对象创建了");
    }

    public void IAccountService() {
        System.out.println("业务层处理数据");
    }
}
