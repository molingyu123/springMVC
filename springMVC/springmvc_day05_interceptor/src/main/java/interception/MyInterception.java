package interception;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class MyInterception  implements HandlerInterceptor {
    /**
     *  jdk1.8允许了接口可以由自己实现的方法所以在这里没有出现实现接口后报错
     *  想实现也可也自己重新编写
     */

    /**
     * 预处理方法，在走controller 方法前走这个方法
     * return true 表明放行，会执行下一个拦截器的方法如果没有则执行controller 方法
     * return false 表明不放行，则可以通过request，response 跳转到指定的页面告诉用户
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器方法执行了.....");
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
        return true;
    }


    /**
     * controller 方法执行后，这个方法执行
     * @param request
     * @param response
     * @param handler
     * @param
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("后处理的拦截器方法执行了....");
    }


    /**
     * 最后执行的方法
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("最后执行的拦截器方法。。。。。");
    }
}
