package controller;

import bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("test")
public class ResponseController {


    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString 执行了");
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        user.setSex("女");
        model.addAttribute("user",user);
        return "success";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid 执行了");
        //第一种通过跳转两次
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        // 第二种使用重定向
//        response.sendRedirect(request.getContextPath()+"/index.jsp");
        //第三种直接响应
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("你好地球");

        return;
    }

    /**
     * modelAndview 演示 底层也是将javaBean 对象添加到了request 域对象中
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        user.setSex("女");
        modelAndView.addObject("user",user);
        modelAndView.setViewName("success");
        return modelAndView;
    }


    /**
     * 使用关键字演示重定向和转发
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("转发执行了......");
        // 转发演示
//        return "forward:/WEB-INF/pages/success.jsp";

        // 重定向执行
        return "redirect:/index.jsp";
    }

    /**
     * ajax test
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody String body){
        System.out.println("请求成功了");
        System.out.println(body);
        User user = new User();
        user.setSex("男");
        user.setPassword("3234");
        user.setUsername("返回");
        return user;
    }
}
