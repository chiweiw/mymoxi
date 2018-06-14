package com.cww.mymoxi.configurer.interceptor;

import com.cww.mymoxi.model.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//普通拦截器

public class AuthorizationInterceptor implements HandlerInterceptor {

    //不拦截xxx请求
    private static final String[] IGNORE_URL = {"/loginForm", "/login"};

    /*
    * 本方法在进行处理器拦截用的，该方法在COntroller处理之前进行调用
    * 本方法返回值为ture，拦截器才会继续往下执行，该方法返回false时，整个请求就代表结束了。
    * */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {


        System.out.println("普通拦截器正在保护您的安全");
        //flag 登录标志
        boolean flag = false;

        //获取请求路径进行判断
        String servletPath = httpServletRequest.getServletPath();
        for (String s : IGNORE_URL) {
            if (servletPath.contains(s)) {
                flag = true;
                break;

            }
        }

        //拦截请求
        if (!flag) {
            //获取session中的admin
            Admin user = (Admin) httpServletRequest.getSession().getAttribute("admin");

            if (user == null) {
                System.out.println("你好坏，快去登录");
                httpServletRequest.setAttribute("message", "请先登录再来");
                httpServletRequest.getRequestDispatcher("admin/login")
                        .forward(httpServletRequest, httpServletResponse);

            }else {
                System.out.println("放行！！！");
                flag = true;
            }

        }

        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
