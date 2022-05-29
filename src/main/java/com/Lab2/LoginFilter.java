package com.Lab2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/lab2/validate.jsp", "/lab2/welcome.jsp"})
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in LoginFilter--init()");
    }

    public void destroy() {
        System.out.println("i am in LoginFilter--init()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in LoginFilter--doFilter()");
        chain.doFilter(request, response);
        HttpServletRequest req= (HttpServletRequest) request;
        HttpServletResponse res= (HttpServletResponse) response;

        HttpSession session= req.getSession();
        boolean isLoggedIn = (session!=null &&session.getAttribute("login")!=null);
        boolean d= (session.getAttribute("login")!=null);
        System.out.println("message:"+req.getAttribute("message"));
       /* if(isLoggedIn &&req.getAttribute("message")==null){
            System.out.println("aaaaaa");
            res.sendRedirect("/lab2/welcome.jsp");
        }else {
            System.out.println("bbbbb");
            res.sendRedirect("/lab2/validate.jsp");
        }*/
            System.out.println("cccc");
            chain.doFilter(request,response);

        System.out.println("i am in LoginFilter--destroy()");
    }
}
