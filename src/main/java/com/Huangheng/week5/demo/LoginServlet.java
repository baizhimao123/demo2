package com.Huangheng.week5.demo;

import com.Huangheng.dao.UserDao;
import com.Huangheng.model.User;
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
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");


        UserDao userDao=new UserDao();
        try {
            User user= userDao.findByUsernamePassword(con,username,password);

            if (user!=null){

                String rememberMe=request.getParameter("rememberMe");
                if (rememberMe!=null && rememberMe.equals("1")){
                    Cookie usernameCookie=new Cookie("cUsername",user.getUserName());
                    Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                    Cookie rememberMeCookie=new Cookie("cRememberMe",rememberMe);

                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);

                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }

                HttpSession session= request.getSession();
                session.setMaxInactiveInterval(10);

                session.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else {

                request.setAttribute("message","Username or Password Error!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*try {
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
        }*/
    }
}
