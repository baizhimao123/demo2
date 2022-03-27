package com.Huangheng.week5.demo;

import com.Huangheng.week4.demo.JDBCDemoServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        PrintWriter writer= response.getWriter();
        Connection con=null;
        try {
            con= JDBCDemoServlet.getCon();
            String sql= "select * from usertable where UserName="+"'"+username+"'"+"and Password="+"'"+password+"'";
            PreparedStatement preparedStatement=con.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            if (resultSet.next()==true){

                writer.println("Login Successful");
            }else{
                writer.println("Login Failed");
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
