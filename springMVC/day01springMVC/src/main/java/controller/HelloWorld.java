package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * hello 控制类
 * @author mly
 * @date 2019-11-24
 */
@Controller
@RequestMapping("/test")
public class HelloWorld {

    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("你好，java");
        // springmvc 默认这个返回的是一个jsp 的文件名称
        return "success";
    }

    /**
     *  path 参数 表明指定的路径
     *  params 参数 表明传入的参数必须相同否则请求失败
     *  method 参数 表明传入的方法必须是post 类型的请求
     *  headers 参数 表明传入的请求头必须是这个
     * @return
     */
    @RequestMapping(path = "/requestMapping",params = {"username"},method = RequestMethod.GET,headers = {"Accept"})
    public String testRequestMapping(){
        System.out.println("测试requestMapping 这个注解");
        return  "test";
    }
}
