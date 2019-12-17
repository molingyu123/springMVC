package exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器
 */
public class ExceptionHandleSolver implements HandlerExceptionResolver {

    /**
     * 处理异常的业务逻辑
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
       SystemException exception=null;
       if(e instanceof SystemException){
           exception =(SystemException) e;
       }else{
           exception=new SystemException("系统正在维护.....");
       }
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.addObject("errorMsg",exception.getMessage());
       modelAndView.setViewName("error");// 跳转页面
        return modelAndView;
    }
}
