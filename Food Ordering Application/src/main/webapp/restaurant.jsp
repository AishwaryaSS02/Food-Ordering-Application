<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.List,com.tap.model.Restaurant" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Restaurants</title>

<style>
:root{
  --brand:#ff5a00;
  --bg:#f4f6f8;
  --card:#ffffff;
  --text:#1c1c1c;
  --muted:#6b6f76;
  --green:#1ba672;
}

*{
  margin:0;
  padding:0;
  box-sizing:border-box;
  font-family: "Segoe UI",sans-serif;
}

body{
  background:var(--bg);
}

/* ---------- NAVBAR ---------- */
.navbar{
  position:sticky;
  top:0;
  background:rgba(255,255,255,0.8);
  backdrop-filter:blur(10px);
  padding:14px 40px;
  display:flex;
  justify-content:space-between;
  align-items:center;
  box-shadow:0 2px 10px rgba(0,0,0,0.06);
  z-index:1000;
}

.logo{
  font-size:22px;
  font-weight:700;
  color:var(--brand);
}

.nav-links a{
  margin-left:25px;
  text-decoration:none;
  color:var(--text);
  font-weight:500;
  transition:.3s;
}

.nav-links a:hover{
  color:var(--brand);
}

/* ---------- TITLE ---------- */
.heading{
  padding:30px 40px 10px;
  font-size:26px;
  font-weight:700;
}

/* ---------- GRID ---------- */
.container{
  padding:20px 40px 50px;
  display:grid;
  grid-template-columns:repeat(auto-fit,minmax(260px,1fr));
  gap:22px;
}

/* ---------- CARD ---------- */
.card{
  background:var(--card);
  border-radius:16px;
  overflow:hidden;
  transition:.3s;
  box-shadow:0 4px 14px rgba(0,0,0,.08);
}

.card:hover{
  transform:translateY(-6px);
  box-shadow:0 10px 24px rgba(0,0,0,.15);
}

.card img{
  width:100%;
  height:170px;
  object-fit:cover;
}

.content{
  padding:14px;
}

.top{
  display:flex;
  justify-content:space-between;
  align-items:center;
}

.name{
  font-size:17px;
  font-weight:600;
}

.rating{
  background:var(--green);
  color:white;
  font-size:13px;
  padding:3px 7px;
  border-radius:6px;
}

.desc{
  font-size:14px;
  color:var(--muted);
  margin:6px 0;
  height:38px;
  overflow:hidden;
}

.meta{
  font-size:13px;
  color:#888;
  margin-bottom:10px;
}

/* ---------- BUTTONS ---------- */
.cta{
  display:flex;
  justify-content:space-between;
}

.btn{
  padding:6px 12px;
  border-radius:6px;
  border:1px solid var(--brand);
  text-decoration:none;
  font-size:13px;
  color:var(--brand);
  transition:.3s;
}

.btn.primary{
  background:var(--brand);
  color:white;
}

.btn:hover{
  background:var(--brand);
  color:white;
}
</style>
</head>

<body>

<!-- NAVBAR -->
<div class="navbar">
  <div class="logo">QuickBite</div>
  <div class="nav-links">
    <a href="#">Home</a>
    <a href="#">Login</a>
    <a href="aCrt.jsp">Cart</a>
    <a href="#">Profile</a>
  </div>
</div>

<div class="heading">Restaurants Near You</div>

<div class="container">

<!-- 🔁 COPY CARD = 20 RESTAURANTS -->


 
   <%
   List<Restaurant>  allRestaurants=(List<Restaurant>)request.getAttribute("allRestaurants");
   
   for(Restaurant restaurant : allRestaurants) {
   %>
   
       <a href="menu?restaurantId=<%=restaurant.getRestaurantId()%>">
       
         
       
       
       
       
       
       
       
       
       
 
        <article class="card">
    	<div class="media">
    	<img src="${pageContext.request.contextPath}/images/<%=restaurant.getImagePath()%>" alt="<%=restaurant.getName() %>"/>
    	<span class="fav" aria-hidden="true"></span>
    	<div class="budges">
    	<span class="tag green"><%=restaurant.getDeliveryTime() %></span>
    	<span class="tag purple"><%=restaurant.getAddress() %></span>
    	</div>
    	</div>
    	<div class="content">
    	<div class="toprow">
    	<span class="name"><%=restaurant.getName()%></span>
    	<span class="rating">4.6★</span>
    	</div>
    	<p class="desc"><%=restaurant.getCuisineType() %></p>
    	<div class="meta">
    	<span>Indian</span>
    	<span>Free delivery</span>
    	</div>
    	</div>
    	</article>
    	</a>
    <%
	 }
    %>


</body>
</html>
    
    
    
    

   
    