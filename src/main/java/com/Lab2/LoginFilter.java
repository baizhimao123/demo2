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
        HttpServletRequest req= (HttpServletRequest) request;

        HttpSession session= req.getSession(false);
        if(session!=null&&session.getAttribute("message")==null){
            req.getRequestDispatcher("/lab2/welcome.jsp").forward(request,response);

        }else if (session ==null && session.getAttribute("message")!=null){
            req.getRequestDispatcher("/lab2/login.jsp").forward(request,response);
        }else {
            chain.doFilter(request, response);
        }

        System.out.println("i am in LoginFilter--destroy()");
    }
}
