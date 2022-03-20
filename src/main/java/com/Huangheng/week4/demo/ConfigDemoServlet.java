package com.Huangheng.week4.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "configDemoServlet",value = "/config",
initParams = {
        @WebInitParam(name = "name",value = "Huangheng"),
        @WebInitParam(name = "student_id",value = "2020211001001405")
}
)
public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config=getServletConfig();
        String name=config.getInitParameter("name");
        String student_id= config.getInitParameter("student_id");

        PrintWriter writer=response.getWriter();
        writer.println("Name:"+name);
        writer.println("StudentId:"+student_id);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
