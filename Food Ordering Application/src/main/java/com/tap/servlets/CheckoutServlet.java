package com.tap.servlets;

import java.io.IOException;
import java.sql.Timestamp;

import com.tap.DAOImplementation.OrderDaoImple;
import com.tap.DAOImplementation.orderItemDaoImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.OrderItem;
import com.tap.model.User;
import com.tap.model.orders;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		Cart cart=(Cart)session.getAttribute("cart");
		User user=(User)session.getAttribute("user");
		
		int restaurantId=(Integer)session.getAttribute("oldRestaurantId");
		
		String address = req.getParameter("address");
		String paymentMethod=req.getParameter("paymentMethod");
		
		if(user == null)
		{
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
		
		if(cart != null && user != null && !cart.getItems().isEmpty())
		{
		  orders order=new orders();
		  order.setUserId(user.getUserid());
		  order.setRestaurantId(restaurantId);
		  order.setOrderDate(new Timestamp(System.currentTimeMillis()));
		  order.setAddress(address);
		  order.setStatus("pending");
		  order.setPaymentMode(paymentMethod);
		  
		  double totalAmount=0.0;
		  
		  for(CartItem item :cart.getItems().values()) {
			totalAmount =totalAmount+item.getQuantity()*item.getPrice();
		  }
		  order.setTotalAmount(totalAmount);
		  
		  OrderDaoImple orderDaoImple=new OrderDaoImple();
		  int orderId=orderDaoImple.addOrder(order);
		  
		  
		  for(CartItem item :cart.getItems().values()) {
			  int itemId=item.getItemId();
			  int quantity=item.getQuantity();
			  double totalPrice= item.getTotalPrice();
			  
			  OrderItem orderItem=new OrderItem();
			  orderItem.setOrderId(orderId);
			  orderItem.setMenuId(itemId);
			  orderItem.setQuantity(quantity);
			  orderItem.setTotalAmount(totalAmount);
			  
			  orderItemDaoImpl orderitemDaoImpl=new orderItemDaoImpl();
			   orderitemDaoImpl.addOrderItem(orderItem);  
		  }
		  
		  session.removeAttribute("cart");
		  session.removeAttribute("oldRestaurantId");
		  resp.sendRedirect("orderConfirmation.jsp");
		  
		} else {
			resp.sendRedirect("cart.jsp");
		}
	}
}

