<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Admin Home</title>
</head>
<body>
    <h1>Welcome to Admin Home Page</h1>
    <p>This page is accessible to users with ROLE_ADMIN.</p>
    <a href="<c:url value='/logout'/>">Logout</a>
</body>
</html>