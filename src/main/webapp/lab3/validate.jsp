<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<%--
if(request.getParameter("username").equals("admin") && request.getParameter("password").equals("admin")){
    String url="welcome.jsp?username="+request.getParameter("username");
    response.sendRedirect(url);
}else{
    request.setAttribute("message","Username Password Error");
    request.getRequestDispatcher("login.jsp").include(request,response);
}
--%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    <sql:setDataSource var="myDS"
                       driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
                       url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=userdb"
                       user="sa"
                       password="123"/>
    <sql:query var="selectUsers" dataSource="${myDS}">
        select * from usertable where UserName='${param.username}' and Password='${param.password}'
    </sql:query>
<%--todo 2: use c:choose ,c:when c:otherwise to validate username is 'admin' and  password is 'admin'--%>
<c:choose>
    <c:when test="${! empty selectUsers.rows}">
         <c:url value="welcome.jsp" var="welcome.jsp?username=admin">
            <c:param name="username" value="${param.username}"/>
         </c:url>
        <c:redirect url="welcome.jsp?username=admin"/>
    </c:when>
    <c:otherwise>
        <c:set value="username password error" var="message"/>
        <c:import url="login.jsp"/>
    </c:otherwise>
</c:choose>
</body>
</html>
