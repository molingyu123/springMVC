package controller;

import bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("anno")
@SessionAttributes(value ={"msg"}) // 等于把msg =美美存入到了session 域中了
public class AnnoController {

    /**
     * @RequestParam 这个注解用于接受的参数上，可以通过注解指定当前接受的参数名并赋值给参数
     * @param username
     * @return
     */
    @RequestMapping("testRequestParam")
    public String testRequestParam(@RequestParam(name = "username") String username){
        System.out.println("执行了....."+username);
        return "success";
    }

    /**
     * @RequestBody 这个注解获取表单中所以请求体信息
     * @param body
     * @return
     */
    @RequestMapping("requestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("获取的对象:");
        System.out.println(body);
        return "success";
    }

    /**
     * @PathVariable 注解 占位符注解
     * @return
     */
    @RequestMapping("pathVariable/{sid}")
    public String testPathVariable(@PathVariable (value = "sid") String id){
        System.out.println("获取的对象:");
        System.out.println(id);
        return "success";
    }

    /**
     * @RequestHeader 请求头注解演示
     * @return
     */
    @RequestMapping("requestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header){
        System.out.println("获取的对象:");
        System.out.println(header);
        return "success";
    }

    /**
     * @CookValue 注解必须添加指定参数
     * @param cook
     * @return
     */
    @RequestMapping("requestCook")
    public String testRequestCook(@CookieValue(value = "JSESSIONID") String cook){
        System.out.println("获取的对象:");
        System.out.println(cook);
        return "success";
    }

    /**
     * ModelAttribute
     * @return
     */
    @RequestMapping("modelAttribute")
    public String testModelAttritue(@ModelAttribute(value = "abc") User user){
        System.out.println("控制器方法执行了>.....");
        System.out.println(user);
        return "success";
    }

    /**
     * @ModelAttribute 使用这个注解的方法会再请求过来的方法前执行该方法
     *   作用： 当你请求的封装的表单中只提交了一个对象的部分属性，剩余的属性如果想查询到
     *   可以根据部分数据去数据库中查询后返回，使用该注解的就可以解决这个问题
     */
    @ModelAttribute
    public User showModel(String clientName){
        System.out.println("showModel 方法执行了。。。。");
        User user = new User();
        user.setClientName(clientName);
        user.setSex("女");
        user.setDate(new Date());
        return user;
    }

    @ModelAttribute
    public void showModel(String clientName,Map<String,User>map){
        System.out.println("showModel 方法执行了。。。。");
        User user = new User();
        user.setClientName(clientName);
        user.setSex("女");
        user.setDate(new Date());
        map.put("abc",user);
    }

    /**
     * @SessionAttributes
     * @return
     */
    @RequestMapping("session")
    public String testSession(Model model){
        System.out.println("model>.....");
        // 底层会存取到request 域对象中
        model.addAttribute("msg","美么没");
        return "success";
    }

    @RequestMapping("getSession")
    public String getSession(ModelMap extendedModelMap){
        System.out.println("model>.....");
        String msg =(String)extendedModelMap.get("msg");
        System.out.println("msg"+msg);
        return "success";
    }

    @RequestMapping("delSession")
    public String delSession(SessionStatus sessionStatus){
        System.out.println("model>.....");
        sessionStatus.setComplete();
        return "success";
    }


}
