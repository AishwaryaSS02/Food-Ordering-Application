<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Login - Swiggy Clone</title>
<style>
body {
	font-family: 'Inter', sans-serif;
	background: linear-gradient(to bottom, #ffe9c3, #ffffff);
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
	color: #333;
}

.login-container {
	background: white;
	padding: 2rem 3rem;
	border-radius: 15px;
	box-shadow: 0 8px 20px rgba(252, 128, 25, 0.4);
	width: 100%;
	max-width: 400px;
	text-align: center;
}

h1 {
	color: #fc8019;
	margin-bottom: 1.5rem;
}

input[type="text"], input[type="password"] {
	width: 100%;
	padding: 0.75rem 1rem;
	margin-bottom: 1rem;
	border: 2px solid #fc8019;
	border-radius: 25px;
	font-size: 1rem;
	outline: none;
	transition: border-color 0.3s ease;
}

input[type="text"]:focus, input[type="password"]:focus {
	border-color: #e06f0f;
}

button {
	background-color: #fc8019;
	border: none;
	color: white;
	padding: 0.75rem 1.5rem;
	border-radius: 25px;
	font-weight: 700;
	cursor: pointer;
	width: 100%;
	font-size: 1rem;
	transition: background-color 0.3s ease;
}

button:hover {
	background-color: #e06f0f;
}

.register-link {
	margin-top: 1rem;
	font-size: 0.9rem;
}

.register-link a {
	color: #fc8019;
	text-decoration: none;
}

.register-link a:hover {
	text-decoration: underline;
}

.error-message {
	color: red;
	margin-bottom: 1rem;
	font-weight: bold;
}
</style>
</head>
<body>
	<div class="login-container">
		<h1>Login to Swiggy</h1>

		<!-- Show error message if present -->
		<c:if test="${not empty error}">
			<div class="error-message">${error}</div>
		</c:if>

		<!-- Login Form -->
            <form action="<%=request.getContextPath()%>/login" method="post">
			<input type="text" name="email"
				placeholder="email" required /> <input type="password"
				name="password" placeholder="Password" required />
			<button type="submit">Login</button>
		</form>

		<div class="register-link">
			Don't have an account? <a href="registration.jsp">Register here</a>
		</div>
	</div>
</body>
</html>