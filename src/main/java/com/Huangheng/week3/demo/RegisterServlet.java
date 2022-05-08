package com.Huangheng.week3.demo;

import com.Huangheng.week4.demo.JDBCDemoServlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns = {"/register"},loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {

    Connection con=null;

    @Override
    public void init() throws ServletException {
        super.init();
        /*ServletContext context=getServletContext();
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
        }*/
        con= (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String Email=request.getParameter("email");
        String sex=request.getParameter("gender");
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
        try {
            Statement statement=con.createStatement();
            String sql= "insert into usertable(UserName,Password,Email,Gender,Birthdate)"+
                    " values('"+username+"','"+password+"','"+Email+"','"+sex+"','"+birthdate+"')";
            System.out.println("sql"+sql);
            int n= statement.executeUpdate(sql);
            System.out.println("n>"+n);

            //sql="select * from usertable";
           // ResultSet resultSet=statement.executeQuery(sql);

           // PrintWriter printWriter=response.getWriter();
            //printWriter.println("<html><title></title><body><table border=1><br>");
           // printWriter.println("<td>Username</td><td>Password</td><td>Email</td><td>Gender</td><td>Birthdate</td>");

          /*  while (resultSet.next()){
                printWriter.println("<tr>");
                printWriter.println("<td>"+resultSet.getString("UserName")+"</td>");
                printWriter.println("<td>"+resultSet.getString("Password")+"</td>");
                printWriter.println("<td>"+resultSet.getString("Email")+"</td>");
                printWriter.println("<td>"+resultSet.getString("Gender")+"</td>");
                printWriter.println("<td>"+resultSet.getString("Birthdate")+"</td>");
                printWriter.println("</tr>");
            }*/
           // printWriter.println("</table></body></html>");
            //request.setAttribute("rsname",resultSet);
            //request.getRequestDispatcher("UserList.jsp").forward(request,response);
            response.sendRedirect("login");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*PrintWriter writer= response.getWriter();
        writer.println("<br>username :"+username);
        writer.println("<br>password :"+password);
        writer.println("<br>Email :"+Email);
        writer.println("<br>sex :"+sex);
        writer.println("<br>birthdate :"+birthdate);
        writer.close();*/
    }

}
