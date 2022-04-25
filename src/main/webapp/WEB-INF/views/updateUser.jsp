<%--
  Created by IntelliJ IDEA.
  User: 初
  Date: 2022/4/18
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.Huangheng.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Update</h1>

<%
  User user_update= (User) session.getAttribute("user");
%>
<form method="post" action="updateUser">
  ID:<input type="text" name="id" value="<%=user_update.getID()%>"><br>
  Username:<input type="username" name="username" value="<%=user_update.getUserName()%>"><br>
  Password:<input type="password" name="password" value="<%=user_update.getPassword()%>"><br>
  Email:<input type="text" name="Email" value="<%=user_update.getEmail()%>"><br>
  Gender:
  <input type="radio" name="sex" value="Male" <%="Male".equals(user_update.getGender())?"checked" :""%>>Male
  <input type="radio" name="sex" value="Female" <%="Female".equals(user_update.getGender())?"checked" :""%>>Female<br>
  Date of Birth<input type="text" name="birthdate" value="<%=user_update.getBirthdate()%>"><br>
  <input type="submit" value="Save Changes"/>
</form>
<%@include file="footer.jsp" %>

