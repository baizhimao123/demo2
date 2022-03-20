<%@ page import="java.sql.*" %>
<%@ page import="com.Huangheng.week4.demo.JDBCDemoServlet" %><%--
  Created by IntelliJ IDEA.
  User: 初
  Date: 2022/3/20
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息查询</title>
</head>
<body>
     <%
    try {
        Connection con=null;
        con= JDBCDemoServlet.getCon();
     %>
    <table border="2">
        <tr>
            <th>UserName</th>
            <th>Password</th>
            <th>Email</th>
            <th>Gender</th>
            <th>Birthdate</th>
        </tr>
    <%
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM usertable;";
        stmt = con.createStatement();
        rs = stmt.executeQuery(sql);
        while (rs.next()) {
    %>
        <tr>
            <td><%=rs.getString("UserName")%></td>
            <td><%=rs.getString("Password")%></td>
            <td><%=rs.getString("Email")%></td>
            <td><%=rs.getString("Gender")%></td>
            <td><%=rs.getString("Birthdate")%></td>
        </tr>
        <%
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        %>
</body>
</html>
