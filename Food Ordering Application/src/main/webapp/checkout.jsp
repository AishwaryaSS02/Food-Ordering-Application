<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.tap.model.Cart, com.tap.model.CartItem, java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>

<style>
body{
    margin:0;
    font-family: Arial, Helvetica, sans-serif;
    background:#f4f4f4;
}

.container{
    width:420px;
    background:white;
    margin:60px auto;
    padding:25px 30px;
    border-radius:10px;
    box-shadow:0 4px 10px rgba(0,0,0,0.15);
}

h2{
    text-align:center;
    color:#ff6b00;
}

label{
    display:block;
    margin-top:15px;
    font-weight:bold;
}

textarea, select{
    width:100%;
    padding:10px;
    margin-top:6px;
    border-radius:6px;
    border:1px solid #ccc;
}

textarea{
    resize:none;
    height:90px;
}

.total-box{
    margin-top:20px;
    padding:10px;
    background:#f9f9f9;
    border-radius:6px;
    font-weight:bold;
}

button{
    width:100%;
    margin-top:20px;
    padding:12px;
    background:green;
    color:white;
    font-size:16px;
    border:none;
    border-radius:7px;
    cursor:pointer;
}

button:hover{
    background:#1a8f1a;
}
</style>
</head>
<body>

  <div class="container">
  <h2>Checkout</h2>
  <form action="checkout" method="post">
  <label for="address">Delivery Address</label>
  <textarea id="address" name="address" required></textarea>
  <label for="paymentMethod">Payment Method:</label>
  <select name="paymentMethod" id="paymentMethod" required>
  <option value="Credit Card">Credit Card</option>
  <option value="Debit Card">Debit Card</option>
  <option value="Cash on Delivery">Cash on Delivery</opyion>
  </select>
  <input type="submit" value="Place Order">
  
  </form>
  </div>
</body>
</html>