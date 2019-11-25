package controller;

import bean.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 请求参数绑定
 * @author mly
 */
@Controller
@RequestMapping(value = "/param")
public class ParamController {

    /**
     * 请求参数绑定
     * @return
     */
    @RequestMapping("requestParam")
    public String testParam(String username){
        System.out.println("参数绑定成功了"+username);
        return "success";
    }

    /**
     * 表单提交方法的演示
     * @param account
     * @return
     */
    @RequestMapping("saveAccount")
    public String saveAccount(Account account){
        System.out.println("参数绑定成功了"+account);
        return "success";
    }
}
