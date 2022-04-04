package com.Huangheng.week5.demo;

import com.Huangheng.week4.demo.JDBCDemoServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class LoginServlet extends HttpServlet {
    Connection con=null;

    @Override
    public void init() throws ServletException {
        super.init();
        con= (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        PrintWriter writer= response.getWriter();

        try {
            Statement statement=con.createStatement();
            String sql= "select * from usertable where UserName="+"'"+username+"'"+"and Password="+"'"+password+"'";
            ResultSet resultSet=statement.executeQuery(sql);
            if (resultSet.next()==true){
                //writer.println("Login Successful");
                request.setAttribute("username",resultSet.getString("UserName"));
                request.setAttribute("password",resultSet.getString("Password"));
                request.setAttribute("Email",resultSet.getString("Email"));
                request.setAttribute("sex",resultSet.getString("Gender"));
                request.setAttribute("birthdate",resultSet.getString("Birthdate"));

                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
                System.out.println("successful");
            }else{
               // writer.println("Login Failed");
                request.setAttribute("message","Username or Password Error!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
