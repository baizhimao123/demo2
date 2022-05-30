package com.Lab1;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LifeCycleServlet extends HttpServlet {
    private int count=0;
    @Override
    public void init() throws ServletException {
        System.out.println("init");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("service");
        Test();
        count++;
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Since loading,this servlet has been accessed " + count + "times" + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void Test(){
        System.out.println("test");
    }
    @Override
    public void destroy() {
        System.out.println("destroy");

    }
}
