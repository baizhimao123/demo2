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
<%--todo 2: use c:choose ,c:when c:otherwise to validate username is 'admin' and  password is 'admin'--%>
<c:choose>
    <c:when test="<%="admin".equals(request.getParameter("username"))%>">
         <c:url value="welcome.jsp" var="welcome.jsp?username=admin">
            <c:param name="username" value="<%=request.getParameter("username")%>"/>
         </c:url>
        <c:redirect url="welcome.jsp?username=admin"/>
    </c:when>
<c:otherwise>
    <c:set value="message"   var="username password error" scope="session"/>
    <c:import url="login.jsp"/>
</c:otherwise>
</c:choose>
</body>
</html>
