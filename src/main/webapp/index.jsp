<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%--<h1><%= "Hello World!" %>--%>
<%--</h1>--%>
<%--<br/>--%>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
<form action="welcome" method="get">
    Enter your name<input type="text" name="name"><br>

    Password:<input type="password" name="userPass"/><br/>
    <input type="submit" value="login"><br>
</form>
</body>
</html>