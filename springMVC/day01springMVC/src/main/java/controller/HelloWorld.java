package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * hello 控制类
 * @author mly
 * @date 2019-11-24
 */
@Controller
public class HelloWorld {

    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("你好，java");
        // springmvc 默认这个返回的是一个jsp 的文件名称
        return "success";
    }
}
