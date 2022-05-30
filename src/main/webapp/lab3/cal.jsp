<%--
  Created by IntelliJ IDEA.
  User: 初
  Date: 2022/5/30
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <form action="validate" method="post">
        First val: <input type="text" name="firstVal">
        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
        Enter a name:<input type="text" name="name">
        <br>
        Second val: <input type="text" name="secondVal">
        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
        Length:<input type="text" name="length">
        <br>
        Result:<input type="text" name="result">
        <input type="submit" value="Add" name="add"/>
        <input type="submit" value="Subtract" name="subtract"/>
        <input type="submit" value="Multiply" name="multiply"/>
        <input type="submit" value="Divide" name="divide"/>
        <input type="submit" value="Compute Length" name="computeLength"/><br>
        <input type="submit" value="Reset">
    </form>
</head>
<body>

</body>
</html>
