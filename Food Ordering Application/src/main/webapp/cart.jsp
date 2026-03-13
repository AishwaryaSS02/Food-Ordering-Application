<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.*, com.tap.model.Cart, com.tap.model.CartItem" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Cart</title>

<style>
body{
    font-family: Arial, sans-serif;
    background:#f5f5f5;
    margin:0;
}

/* Header */
.header{
    background:#ff6b00;
    color:white;
    padding:15px 30px;
    font-size:22px;
    font-weight:bold;
}

/* Container */
.cart-container{
    width:80%;
    margin:30px auto;
}

/* Each Item */
.cart-item{
    display:flex;
    align-items:center;
    justify-content:space-between;
    background:white;
    padding:15px;
    margin-bottom:15px;
    border-radius:10px;
    box-shadow:0 2px 6px rgba(0,0,0,0.1);
}

/* Left Section */
.item-left{
    display:flex;
    align-items:center;
    gap:15px;
}

.item-left img{
    width:80px;
    height:80px;
    border-radius:8px;
    object-fit:cover;
}

.item-name{
    font-size:18px;
    font-weight:bold;
}

.item-price{
    color:green;
    margin-top:5px;
}

/* Quantity Controls */
.quantity-box{
    display:flex;
    align-items:center;
    gap:10px;
}

.qty-btn{
    background:#ff6b00;
    color:white;
    border:none;
    padding:6px 12px;
    font-size:16px;
    border-radius:5px;
    cursor:pointer;
}

.qty-btn:hover{
    background:#e65c00;
}

/* Remove Button */
.remove-btn{
    background:red;
    color:white;
    border:none;
    padding:6px 12px;
    border-radius:5px;
    cursor:pointer;
}

/* Total Section */
.total-box{
    background:white;
    padding:20px;
    border-radius:10px;
    text-align:right;
    font-size:20px;
    font-weight:bold;
}

.checkout-btn{
    background:green;
    color:white;
    padding:12px 25px;
    border:none;
    margin-top:15px;
    font-size:16px;
    border-radius:8px;
    cursor:pointer;
}
</style>
</head>

<body>

<div class="header">Your Cart</div>

<div class="cart-container">
<%
Cart cart = (Cart) session.getAttribute("cart");
Integer restaurantId = (Integer) session.getAttribute("oldRestaurantId");

double total = 0;

if(cart != null && !cart.getItems().isEmpty()){
    for(CartItem item : cart.getItems().values()){
        total += item.getTotalPrice();
%>

<div class="cart-item">
    <div class="item-left">
        <img src="images/<%=item.getImage()%>" alt="item">

        <div>
            <div class="item-name"><%=item.getItemName()%></div>
            <div class="item-price">₹<%=item.getPrice()%></div>
            <div>Total: ₹<%=item.getTotalPrice()%></div>
        </div>
    </div>

    <!-- Quantity Controls -->
    <div class="quantity-box">

        <!-- Decrease -->
        <form action="<%=request.getContextPath()%>/cart" method="get">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="itemId" value="<%=item.getItemId()%>">
            <input type="hidden" name="restaurantId" value="<%=restaurantId%>">
            <input type="hidden" name="quantity" value="<%=item.getQuantity()-1%>">
            <button class="qty-btn">-</button>
        </form>

        <b><%=item.getQuantity()%></b>

        <!-- Increase -->
        <form action="<%=request.getContextPath()%>/cart"  method="get">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="itemId" value="<%=item.getItemId()%>">
            <input type="hidden" name="restaurantId" value="<%=restaurantId%>">
            <input type="hidden" name="quantity" value="<%=item.getQuantity()+1%>">
            <button class="qty-btn">+</button>
        </form>
    </div>

    <!-- Remove -->
       <form action=""<%=request.getContextPath()%>/cart"" method="get">
        <input type="hidden" name="action" value="delete">
        <input type="hidden" name="itemId" value="<%=item.getItemId()%>">
        <button class="remove-btn">Remove</button>
    </form>
</div>

<%
    } // end for loop
%>

<!-- Total Section -->
<div class="total-box">
    Grand Total: ₹<%=total%>

    <form action="checkout.jsp" method="post">
        <button class="checkout-btn">Proceed to Checkout</button>
    </form>
</div>

<%
}else{
%>
    <h2>Your cart is empty 😔</h2>
<%
}
%>
</body>
</html>