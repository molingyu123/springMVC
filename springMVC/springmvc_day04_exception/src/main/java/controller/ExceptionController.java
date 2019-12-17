package controller;

import exception.SystemException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 异常处理类
 */
@Controller
@RequestMapping("user")
public class ExceptionController {


    @RequestMapping("/exception")
    public String  exception() throws SystemException{
        System.out.println("异常执行了...");
        // 模拟异常
        try {
            int a =10/0;
        } catch (Exception e) {
            e.printStackTrace();
            // 抛出自定义信息
            throw new SystemException("用户查询出错了...");
        }

        return "success";
    }
}
