package com.Huangheng.week3.demo;

import com.Huangheng.week4.demo.JDBCDemoServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
    /*
    Connection con=null;

    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext context=getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection -->JDBCDemoServlet-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String Email=request.getParameter("Email");
        String sex=request.getParameter("sex");
        String birthdate=request.getParameter("birthdate");

        /*
        try {
            String sql="select * from usertable";
            PreparedStatement preparedStatement= con.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            String[] colHeads={};
            int i=0;
            Object[][] base=new Object[i][4];
            while (resultSet.next()){
                base[i][0] = resultSet.getString("UserName");
                base[i][1] = resultSet.getString("Password");
                base[i][2] = resultSet.getString("Email");
                base[i][3] = resultSet.getString("Gender");
                base[i][4] = resultSet.getString("Birthdate");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        Connection con=null;
        try {
            con= JDBCDemoServlet.getCon();
            String sql= "insert into usertable(UserName,Password,Email,Gender,Birthdate) values(?,?,?,?,?) ";
            PreparedStatement preparedStatement= con.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,Email);
            preparedStatement.setString(4,sex);
            preparedStatement.setString(5,birthdate);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        PrintWriter writer= response.getWriter();
        writer.println("<br>username :"+username);
        writer.println("<br>password :"+password);
        writer.println("<br>Email :"+Email);
        writer.println("<br>sex :"+sex);
        writer.println("<br>birthdate :"+birthdate);
        writer.close();
    }

}
