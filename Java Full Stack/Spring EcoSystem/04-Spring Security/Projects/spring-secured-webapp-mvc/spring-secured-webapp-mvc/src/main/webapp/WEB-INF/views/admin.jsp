<html>
<head>
<title>Admin</title>
</head>
<body>
<h1>Welcome to the Admin page!</h1>
<p>Only administrators can access this page.</p>
<a href="home">go to home</a>

<br><br>

<form action="${pageContext.request.contextPath}/logout" method="post">

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

    <button type="submit">Logout</button>

</form>

</body>
</html>