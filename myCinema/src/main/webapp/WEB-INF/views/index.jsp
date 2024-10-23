<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Index</title>
</head>
<body>
	<h1>MyMovie</h1>

	<div th:if="${username}">
		<p th:text="'Logged in as: ' + ${username}"></p>
		<p th:text="'Roles: ' + ${roles}"></p>
	</div>

	<div th:if="${not #lists.isEmpty(roles)}">
		<div th:if="${#lists.contains(roles, 'ROLE_ADMIN')}">
			<p>You are logged in as an Admin.</p>
		</div>
		<div th:if="${#lists.contains(roles, 'ROLE_USER')}">
			<p>You are logged in as a User.</p>
		</div>
	</div>

	<a href="${pageContext.request.contextPath}/logout">Logout</a>
<%-- 	<a href="${pageContext.request.contextPath }/movies">게시판</a> --%>

</body>
</html>
