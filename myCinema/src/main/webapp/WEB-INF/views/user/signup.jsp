<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Sign Up</title>
    <script>
        function validateSignup() {
            const username = document.getElementById("username").value;
            const password = document.getElementById("password").value;
            if (!username || !password) {
                alert("Username and password are required.");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<h2>Sign Up</h2>
<form action="${pageContext.request.contextPath}/signup" method="post" onsubmit="return validateSignup();">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required />
    <br/>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required />
    <br/>
    <button type="submit">Sign Up</button>
</form>
<a href="${pageContext.request.contextPath}/login">Already have an account? Login here</a>
</body>
</html>
