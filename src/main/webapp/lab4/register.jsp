<%--
  Created by IntelliJ IDEA.
  User: 初
  Date: 2022/6/5
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<form method="post" action="register.jsp">
    Username <input type="text" name="username"><br>
    Password <input type="password" name="password"><br>
    Email <input type="text" name="email"><br>
    Gender <input type="radio" name="gender" value="male">Male
            <input type="radio" name="gender" value="female">Female<br>
    Date of Birth <input type="text" name="birthDate"><br>
    <input type="submit" value="Register">
</form>
<sql:setDataSource var="myDS"
                   driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
                   url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=userdb"
                   user="sa"
                   password="123"/>
<c:if test="${!empty param.username}">
   <sql:update var="newUser" dataSource="${myDS}">
       insert into usertable values(?,?,?,?,?);
       <sql:param value="${param.username}"/>
       <sql:param value="${param.password}"/>
       <sql:param value="${param.email}"/>
       <sql:param value="${param.gender}"/>
       <sql:param value="${param.birthDate}"/>
   </sql:update>
</c:if>

<sql:query var="selectUsers" dataSource="${myDS}">
    select * from usertable
</sql:query>
<table>
    <tr>
    </tr>
    <c:forEach var="row" items="${selectUsers.rows}">
        <tr>
            <td><c:out value="${row.Id}"/></td>
            <td><c:out value="${row.UserName}"/></td>
            <td><c:out value="${row.Password}"/></td>
            <td><c:out value="${row.Email}"/></td>
            <td><c:out value="${row.Gender}"/></td>
            <td><c:out value="${row.Birthdate}"/></td>
        </tr>
    </c:forEach>
</table>
