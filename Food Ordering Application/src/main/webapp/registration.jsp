<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Register - Swiggy Clone</title>
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

.register-container {
	background: white;
	padding: 2rem 3rem;
	border-radius: 15px;
	box-shadow: 0 8px 20px rgba(252, 128, 25, 0.4);
	width: 100%;
	max-width: 450px;
	text-align: center;
}

h1 {
	color: #fc8019;
	margin-bottom: 1.5rem;
}

input, select {
	width: 100%;
	padding: 0.75rem 1rem;
	margin-bottom: 1rem;
	border: 2px solid #fc8019;
	border-radius: 25px;
	font-size: 1rem;
	outline: none;
	transition: border-color 0.3s ease;
}

input:focus, select:focus {
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

.login-link {
	margin-top: 1rem;
	font-size: 0.9rem;
}

.login-link a {
	color: #fc8019;
	text-decoration: none;
}

.login-link a:hover {
	text-decoration: underline;
}

.success-message {
	color: #28a745;
	margin-bottom: 1rem;
	font-weight: 600;
}

.error-message {
	color: red;
	margin-bottom: 1rem;
}
</style>
</head>
<body>
	<div class="register-container">
		<h1>Create an Account</h1>

		<%
		String message = request.getParameter("message");
		if (message != null) {
		%>
		<div
			class="<%=(message != null && message.contains("success Please Login")) ? "success-message" : "error-message"%>">
			<%=message%>
		</div>

		<%
		}
		%>

		<form action="register" method="post">
			<input type="text" name="name" placeholder="Full Name" required /> <input
				type="text" name="username" placeholder="Username" required /> <input
				type="email" name="email" placeholder="Email" required /> <input
				type="password" name="password" placeholder="Password" required />
			<input type="text" name="phone" placeholder="Phone Number" required />
			<input type="text" name="address" placeholder="Address" required />
			<select name="role" required>
				<option value="">Select Role</option>
				<option value="user">user</option>
				<option value="admin">Customer</option>
				<option value="admin">ResturantAdmin</option>
				<option value="admin">SuperAdmin</option>
			</select>
			<button type="submit">Register</button>
		</form>

		<div class="login-link">
			Already have an account? <a href="login.jsp">Login here</a>
		</div>
	</div>
</body>
</html>
