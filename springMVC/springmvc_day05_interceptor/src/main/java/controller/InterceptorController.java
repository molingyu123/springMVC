package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 拦截器演示
 */
@Controller
@RequestMapping("user")
public class InterceptorController {

    @RequestMapping("/interception")
    public String test(){
        System.out.println("controller方法执行了...");
        return "success";
    }
}
