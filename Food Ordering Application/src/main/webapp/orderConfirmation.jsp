<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Confirmation</title>

<style>
body{
    margin:0;
    font-family: Arial, Helvetica, sans-serif;
    background:#f4f6f8;
}

.container{
    width:450px;
    margin:90px auto;
    background:white;
    border-radius:12px;
    text-align:center;
    padding:30px;
    box-shadow:0 6px 18px rgba(0,0,0,0.15);
}

.success-icon{
    width:80px;
    height:80px;
    margin:0 auto 15px;
    background:#28a745;
    border-radius:50%;
    display:flex;
    align-items:center;
    justify-content:center;
    color:white;
    font-size:40px;
}

h2{
    color:#28a745;
    margin-bottom:10px;
}

p{
    color:#555;
    font-size:15px;
    line-height:1.6;
}

.order-box{
    background:#fafafa;
    padding:15px;
    border-radius:8px;
    margin-top:20px;
    font-size:14px;
    color:#333;
    text-align:left;
}

.label{
    font-weight:bold;
    color:#000;
}

.btn{
    display:inline-block;
    margin-top:25px;
    padding:12px 25px;
    background:#ff6b00;
    color:white;
    text-decoration:none;
    border-radius:7px;
    font-size:15px;
}

.btn:hover{
    background:#e65c00;
}
</style>
</head>

<body>

<%
    // Values sent from CheckoutServlet
    int orderId = (Integer) request.getAttribute("orderId");
    String address = (String) request.getAttribute("address");
    String paymentMode = (String) request.getAttribute("paymentMode");
    double totalAmount = (Double) request.getAttribute("totalAmount");
%>

<div class="container">

    <div class="success-icon">✓</div>

    <h2>Order Placed Successfully!</h2>

    <p>
        Thank you for your order.<br>
        Your food is being prepared and will be delivered shortly.
    </p>

    <div class="order-box">
        <p><span class="label">Order ID:</span> <%= orderId %></p>
        <p><span class="label">Delivery Address:</span> <%= address %></p>
        <p><span class="label">Payment Method:</span> <%= paymentMode %></p>
        <p><span class="label">Total Amount:</span> ₹ <%= totalAmount %></p>
        <p><span class="label">Estimated Delivery:</span> 30 – 40 Minutes</p>
        <p><span class="label">Status:</span> Confirmed</p>
    </div>

    <a href="home.jsp" class="btn">Back to Home</a>

</div>

</body>
</html>