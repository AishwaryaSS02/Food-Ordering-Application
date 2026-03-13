<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.tap.model.Restaurant"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food Ordering Application</title>

<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:'Poppins',sans-serif;
}

body{
background:#f5f5f5;
}

/* NAVBAR */

.navbar{
display:flex;
justify-content:space-between;
align-items:center;
padding:15px 40px;
background:white;
box-shadow:0 2px 5px rgba(0,0,0,0.1);
}

.logo{
font-size:26px;
font-weight:bold;
color:#fc8019;
}

.nav-links a{
margin-left:20px;
text-decoration:none;
font-weight:500;
color:#333;
}

.nav-links a:hover{
color:#fc8019;
}

/* HEADER */

.header{
background:url("https://images.unsplash.com/photo-1504674900247-0877df9cc836");
height:300px;
background-size:cover;
display:flex;
align-items:center;
justify-content:center;
flex-direction:column;
color:white;
text-shadow:1px 1px 5px black;
}

.header h1{
font-size:40px;
margin-bottom:10px;
}

/* RESTAURANT GRID */

.container{
width:90%;
margin:auto;
margin-top:40px;
display:grid;
grid-template-columns:repeat(3,1fr);
gap:30px;
}

.card{
background:white;
border-radius:10px;
overflow:hidden;
box-shadow:0 4px 10px rgba(0,0,0,0.1);
transition:0.3s;
}

.card:hover{
transform:scale(1.03);
}

.card img{
width:100%;
height:200px;
object-fit:cover;
}

.card-body{
padding:20px;
}

.card-body h3{
margin-bottom:10px;
}

.desc{
color:#555;
font-size:14px;
margin-bottom:6px;
}

.rating{
background:#48c479;
color:white;
padding:4px 10px;
border-radius:5px;
display:inline-block;
margin-top:10px;
}

/* FOOTER */

.footer{
margin-top:50px;
background:#222;
color:white;
text-align:center;
padding:20px;
}

</style>

</head>

<body>

<!-- NAVBAR -->

<div class="navbar">

<div class="logo">Swiggy</div>

<div class="nav-links">

<a href="<%=request.getContextPath()%>/first">Home</a>

<a href="<%=request.getContextPath()%>/all-menus">Menu</a>

<a href="login.jsp">Login</a>

<a href="Profile.jsp">Profile</a>

<a href="<%=request.getContextPath()%>/cart?action=view">Cart</a>

</div>

</div>


<!-- HEADER -->

<div class="header">

<h1>Order Food Online</h1>

<p>Find restaurants that deliver near you</p>

</div>


<!-- RESTAURANTS -->

<div class="container">

<%

List<Restaurant> restaurants = (List<Restaurant>) request.getAttribute("allRestaurants");

if(restaurants != null && !restaurants.isEmpty()){

for(Restaurant restaurant : restaurants){

if(restaurant.isActive()){

%>

<a href="<%=request.getContextPath()%>/menu?restaurantId=<%=restaurant.getRestaurantId()%>" style="text-decoration:none;color:black;">

<div class="card">

<img src="<%=request.getContextPath()%>/images/<%=restaurant.getImagePath()%>">

<div class="card-body">

<h3><%=restaurant.getName()%></h3>

<p class="desc">
Cuisine : <%=restaurant.getCuisineType()%>
</p>

<p class="desc">
Address : <%=restaurant.getAddress()%>
</p>

<p class="desc">
Delivery Time : <%=restaurant.getDeliveryTime()%> mins
</p>

<div class="rating">

<%=restaurant.getRating()%> ★

</div>

</div>

</div>

</a>

<%

}

}

}

else{

%>

<h2 style="text-align:center;">No Restaurants Available</h2>

<%

}

%>

</div>


<!-- FOOTER -->

<div class="footer">

<p>© 2026 Food Ordering Application</p>

</div>


</body>
</html>