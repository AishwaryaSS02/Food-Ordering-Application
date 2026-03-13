<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    

<%@ page import="com.tap.model.User"%>

<%
User user = (User) request.getAttribute("user");
if (user == null) {
	response.sendRedirect("login.jsp?message=Please+login+first");
	return;
}
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>User Profile</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f8f8f8;
	padding: 30px;
}

.profile-container {
	max-width: 700px;
	margin: 0 auto;
	background: #fff;
	padding: 30px;
	border-radius: 10px;
	box-shadow: 0 0 12px rgba(0, 0, 0, 0.1);
}

h1 {
	color: #fc8019;
	margin-bottom: 25px;
}

.profile-pic {
	text-align: center;
	margin-bottom: 20px;
}

.profile-pic img {
	width: 120px;
	height: 120px;
	border-radius: 50%;
	object-fit: cover;
	border: 3px solid #fc8019;
}

.profile-info label {
	display: block;
	margin-top: 12px;
	font-weight: bold;
}

.profile-info input, textarea {
	width: 100%;
	padding: 8px;
	margin-top: 4px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

button, input[type="submit"] {
	margin-top: 20px;
	background-color: #fc8019;
	border: none;
	padding: 10px 20px;
	color: white;
	font-weight: bold;
	cursor: pointer;
	border-radius: 4px;
}

.logout-btn {
	text-align: right;
}
</style>
</head>
<body>

	<div class="profile-container">
		<h1>
			Welcome,
			<%=user.getUsername() != null ? user.getUsername() : user.getUsername()%>!
		</h1>

		<div class="profile-pic">
			<img src="<%=request.getContextPath()%>/images/default-profile.png"
				alt="Profile Picture" />
			<form action="uploadProfilePic" method="post"
				enctype="multipart/form-data">
				<input type="file" name="profilePic" accept="image/*" /> <input
					type="submit" value="Upload Picture" />
			</form>
		</div>

		<form action="updateProfile" method="post" class="profile-info">
			<label>Full Name:</label> <input type="text" name="name"
				value="<%=user.getUsername()%>" /> <label>Email:</label> <input
				type="email" name="email"
				value="<%=user.getEmail() != null ? user.getEmail() : ""%>" /> <label>Phone:</label>
			<input type="text" name="phone"
				value="<%=user.getAddress() != null ? user.getAddress() : ""%>" /> <label>Address:</label>
			<textarea name="address"><%=user.getAddress() != null ? user.getAddress() : ""%></textarea>

			<input type="submit" value="Update Profile" />
		</form>

		<div class="logout-btn">
			<form action="logout" method="post">
				<input type="submit" value="Logout" />
			</form>
		</div>
	</div>

</body>
</html>
 