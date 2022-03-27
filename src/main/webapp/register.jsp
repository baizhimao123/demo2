<%--
  Created by IntelliJ IDEA.
  User: 初
  Date: 2022/3/15
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="header.jsp"%>

<form method="post" action="register">
    Username:<input type="text" name="username" ><br>
    password:<input type="password" name="password" ><br>
    Email:<input type="text" name="Email" ><br>
    Gender:
    <input type="radio" name="sex" value="Male">Male
    <input type="radio" name="sex" value="Female">Female<br>
    Date of Birth<input type="text" name="birthdate" ><br>
    <input type="submit" value="Register"/>
</form>

<%@include file="footer.jsp"%>

