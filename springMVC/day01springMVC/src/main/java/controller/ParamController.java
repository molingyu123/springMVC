package controller;

import bean.Account;
import bean.User;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;

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

    @RequestMapping(path = "/saveUser",method = RequestMethod.POST)
    public String saveUser(User user){
        System.out.println("添加的对象:"+user);
        return "success";
    }

    /**
     * 获取原生的api
     * @return
     */
    @RequestMapping("getApi")
    public String getAPI(HttpServletRequest request, HttpServletResponse response){
        String requestURI = request.getRequestURI();
        System.out.println("requestURI:"+requestURI);

        String serverName = request.getServerName();
        System.out.println("serverName:"+serverName);

        String contentType = response.getContentType();
        System.out.println("contentType:"+contentType);

        int serverPort = request.getServerPort();
        System.out.println("serverPort:"+serverPort);

        String characterEncoding = response.getCharacterEncoding();
        System.out.println("characterEncoding："+characterEncoding);

        return "success";
    }

}
