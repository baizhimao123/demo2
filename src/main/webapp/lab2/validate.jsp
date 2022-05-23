<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>validate</title>
</head>
<body>
<jsp:useBean id="login" class="com.Lab2.Login" scope="session"/>
<jsp:setProperty name="login" property="*"/>
<%
    if (login.getUsername().equals("admin") && login.getPassword().equals("admin")){
%>

<%--<jsp:getProperty name="login" property="username"/>--%>
<jsp:forward page="welcome.jsp"></jsp:forward>
<jsp:include page="login.jsp"></jsp:include>
<%
    }else {
        request.setAttribute("message","Username Password Error");
        request.getRequestDispatcher("lab2/login.jsp").forward(request,response);
    }
%>
</body>
</html>
