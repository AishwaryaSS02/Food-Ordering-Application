<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@ page import="java.util.List,com.tap.model.menu" %>
    
    <!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Restaurant Menu</title>

<style>
:root{
  --brand:#ff5a00;
  --bg:#f5f6fa;
  --card:#ffffff;
  --text:#222;
  --muted:#777;
  --green:#1ba672;
}

*{
  margin:0;
  padding:0;
  box-sizing:border-box;
  font-family:"Segoe UI",sans-serif;
}

body{
  background:var(--bg);
}

/* ---------- NAVBAR ---------- */
.navbar{
  background:white;
  padding:15px 40px;
  display:flex;
  justify-content:space-between;
  align-items:center;
  box-shadow:0 2px 8px rgba(0,0,0,0.08);
}

.logo{
  font-size:22px;
  font-weight:700;
  color:var(--brand);
}

/* ---------- HEADING ---------- */
.heading{
  padding:25px 40px 10px;
  font-size:26px;
  font-weight:700;
}

/* ---------- GRID ---------- */
.menu-container{
  padding:20px 40px 50px;
  display:grid;
  grid-template-columns:repeat(auto-fit,minmax(250px,1fr));
  gap:22px;
}

/* ---------- CARD ---------- */
.menu-card{
  background:var(--card);
  border-radius:14px;
  overflow:hidden;
  transition:.3s;
  box-shadow:0 4px 14px rgba(0,0,0,.08);
}

.menu-card:hover{
  transform:translateY(-6px);
  box-shadow:0 10px 24px rgba(0,0,0,.15);
}

.menu-card img{
  width:100%;
  height:180px;
  object-fit:cover;
}

/* ---------- CONTENT ---------- */
.content{
  padding:14px;
}

.name{
  font-size:18px;
  font-weight:600;
}

.desc{
  font-size:14px;
  color:var(--muted);
  margin:6px 0 10px;
  height:38px;
  overflow:hidden;
}

.price-rating{
  display:flex;
  justify-content:space-between;
  align-items:center;
  margin-bottom:12px;
}

.price{
  font-size:16px;
  font-weight:600;
  color:var(--brand);
}

.rating{
  background:var(--green);
  color:white;
  font-size:13px;
  padding:3px 7px;
  border-radius:6px;
}

/* ---------- BUTTON ---------- */
.btn{
  width:100%;
  padding:8px;
  border:none;
  background:var(--brand);
  color:white;
  font-size:14px;
  border-radius:6px;
  cursor:pointer;
  transition:.3s;
}

.btn:hover{
  background:#e14d00;
}
</style>
</head>

<body>

<div class="navbar">
  <div class="logo">QuickBite</div>
</div>

<div class="heading">Our Menu</div>


<div class="menu-container">

<%
List<menu> allMenuByRestaurant = (List<menu>)request.getAttribute("allMenuByRestaurant");

for (menu menu : allMenuByRestaurant) {
%>

   <article class="menu-card">

    <div class="media">
        <img src="<%=request.getContextPath()%>/images/<%=menu.getImagePath()%>" alt="menu">
    </div>

    <div class="content">

        <h3 class="name"><%=menu.getItemName()%></h3>
        <p class="desc"><%=menu.getDescription()%></p>

        <div class="price-rating">
            <span class="price">₹<%=menu.getPrice()%></span>
            <span class="rating">4.5★</span>
        </div>

        <div class="cta">
        
        <form action="<%=request.getContextPath()%>/cart" method="get">

    <input type="hidden" name="action" value="add">
    <input type="hidden" name="itemId" value="<%=menu.getMenuId()%>">
    <input type="hidden" name="restaurantId" value="<%=menu.getRestaurantId()%>">
    <input type="hidden" name="quantity" value="1">

    <button type="submit">Add To Cart</button>
</form>
        
        
        
        
        
        
        
        
           
        </div>

    </div>

</article>

<%
}
%>

</body>
</html>