<html>
<head>
<title>Home</title>
</head>
<body>
<h2>Welcome to the Home page!</h2>
<% Boolean isAdmin = (Boolean) request.getAttribute("isAdmin");
if(isAdmin){ %>
    <a href="admin">Admin</a>
<% } %>

<br><br>

<form action="${pageContext.request.contextPath}/logout" method="post">

    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

    <button type="submit">Logout</button>

</form>

</body>
</html>