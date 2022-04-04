<%@ page import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %>
<%--
  Created by IntelliJ IDEA.
  User: 初
  Date: 2022/3/20
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User List</h1>
<table border="1">
    <tr>
        <td>Username</td> <td>Password</td> <td>Email</td> <td>Gender</td> <td>Birthdate</td>
    </tr>
    <%
        ResultSet resultSet= (ResultSet) request.getAttribute("rsname");
        if(resultSet==null){
    %>
    <tr>
        <td>No Data!</td>
    </tr>
     <%   }else {

        while (resultSet.next()){
            out.println("<tr>");
            out.println("<td>"+resultSet.getString("UserName")+"</td>");
            out.println("<td>"+resultSet.getString("Password")+"</td>");
            out.println("<td>"+resultSet.getString("Email")+"</td>");
            out.println("<td>"+resultSet.getString("Gender")+"</td>");
            out.println("<td>"+resultSet.getString("Birthdate")+"</td>");
            out.println("</tr>");
        }
         out.println("</table></body></html>");
     }
    %>
</table>
<%@include file="footer.jsp"%>