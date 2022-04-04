package com.Huangheng.week4.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*@WebServlet(name = "JDBCDemoServlet",urlPatterns = {"/jdbc"},
    initParams = {
        @WebInitParam(name="driver",value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
        @WebInitParam(name="url",value = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=userdb"),
        @WebInitParam(name="username",value = "sa"),
        @WebInitParam(name="password",value = "123")
    },
    loadOnStartup = 1
)*/
/*@WebServlet(urlPatterns = {"/jdbc"},loadOnStartup = 1)*/
public class JDBCDemoServlet extends HttpServlet {
    private static Connection con;
    /*
    @Override
    public void init() throws ServletException {
        super.init();
        /*
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=userdb";
        String username="sa";
        String password="123";
        */
        /*
        ServletConfig config=getServletConfig();
        String driver=config.getInitParameter("driver");
        String url=config.getInitParameter("url");
        String username=config.getInitParameter("username");
        String password=config.getInitParameter("password");


        ServletContext context=getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,password);
            System.out.println("Connection -->JDBCDemoServlet-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }*/

    /*public static Connection getCon() {
        /*ServletContext context=getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=userdb";
        String username="sa";
        String password="123";
        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,password);
            System.out.println("Connection -->JDBCDemoServlet-->"+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Connection -->"+con);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
