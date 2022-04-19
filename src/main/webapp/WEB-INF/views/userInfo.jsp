<%@ page import="com.Huangheng.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 初
  Date: 2022/4/4
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%
  User user_info= (User) session.getAttribute("user");
%>
<table>
  <tr>
    <td>Username:</td><td><%=user_info.getUserName()%></td>
  </tr><tr>
    <td>Password:</td><td><%=user_info.getPassword()%></td>
  </tr><tr>
    <td>Email:</td><td><%=user_info.getEmail()%></td>
  </tr><tr>
    <td>Gender:</td><td><%=user_info.getGender()%></td>
  </tr><tr>
    <td>Birthdate:</td><td><%=user_info.getBirthdate()%></td>
  </tr>
</table>
<a href="updateUser.jsp">Update</a>

<%@include file="footer.jsp"%>
