package com.Lab1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyDearServlet", value = "/myDear")
public class MyDearServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("lab1/myJsp.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name=request.getParameter("username");
        String myClass=request.getParameter("myClass");
        String id=request.getParameter("id");

        request.setAttribute("name", name);
        request.setAttribute("myClass", myClass);
        request.setAttribute("id", id);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>MyDearJsp</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("name:" + name + "<br>");
        out.println("class:" + myClass + "<br>");
        out.println("id:" + id + "<br>");
        out.println("</body>");
        out.println("</html>");
    }
}
