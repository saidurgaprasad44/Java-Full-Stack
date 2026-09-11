<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h2>Login</h2>

<% if (request.getParameter("error") != null) { %>
    <p>Invalid username or password.</p>
<% } %>

<% if (request.getParameter("logout") != null) { %>
    <p>You have been logged out.</p>
<% } %>

<form action="${pageContext.request.contextPath}/login" method="post">

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

    <label>Username:</label>
    <input type="text" name="username">

    <br><br>

    <label>Password:</label>
    <input type="password" name="password">

    <br><br>

    <button type="submit">Login</button>

</form>

</body>
</html>