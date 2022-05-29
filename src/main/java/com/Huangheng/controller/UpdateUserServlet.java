package com.Huangheng.controller;

import com.Huangheng.dao.UserDao;
import com.Huangheng.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con=null;

    @Override
    public void init() throws ServletException {
        super.init();
        con= (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.valueOf(request.getParameter("id"));
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String Email=request.getParameter("Email");
        String sex=request.getParameter("sex");
        String birthdate=request.getParameter("birthdate");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date= null;
        try {
            date = sdf.parse(birthdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        User users=new User();
        users.setID(id);
        users.setUserName(username);
        users.setPassword(password);
        users.setEmail(Email);
        users.setGender(sex);
        users.setBirthdate(date);


        /*String date_t = request.getParameter("birthdate");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Date birthdate=null;
        try {
            birthdate = sdf.parse(date_t);
            System.out.println("date_t:"+date_t);
            System.out.println("birthdate:"+birthdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("date_t 2:"+date_t);
        System.out.println("birthdate 2:"+birthdate);*/



        UserDao userDao=new UserDao();

        try {
            int i=userDao.updateUser(con,users);
            if (i==1){
                users= userDao.findByUsernamePassword(con,username,password);
                if(users!=null){
                    HttpSession session= request.getSession();
                    session.setMaxInactiveInterval(10);

                    session.setAttribute("user",users);
                    request.getRequestDispatcher("accountDetails").forward(request,response);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
