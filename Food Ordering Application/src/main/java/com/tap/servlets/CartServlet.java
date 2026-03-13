package com.tap.servlets;

import java.io.IOException;

import com.tap.DAOImplementation.MenuDaoImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    HttpSession session = req.getSession();

	    Cart cart = (Cart) session.getAttribute("cart");
	    Integer oldRestaurantId = (Integer) session.getAttribute("oldRestaurantId");

	    String restaurantParam = req.getParameter("restaurantId");
	    Integer restaurantId = null;

	    if (restaurantParam != null) {
	        restaurantId = Integer.parseInt(restaurantParam);
	    }

	    if (cart == null) {
	        cart = new Cart();
	        session.setAttribute("cart", cart);
	    }

	    if (restaurantId != null && !restaurantId.equals(oldRestaurantId)) {
	        cart = new Cart();
	        session.setAttribute("cart", cart);
	        session.setAttribute("oldRestaurantId", restaurantId);
	    }

	    String action = req.getParameter("action");

	    if ("add".equals(action)) {

	        addItemToCart(req, cart);
	        resp.sendRedirect(req.getContextPath() + "/cart?action=view");
	        return;

	    } else if ("update".equals(action)) {

	        updateItemOfCart(req, cart);
	        resp.sendRedirect(req.getContextPath() + "/cart?action=view");
	        return;

	    } else if ("delete".equals(action)) {

	        deleteItemFromCart(req, cart);
	        resp.sendRedirect(req.getContextPath() + "/cart?action=view");
	        return;
	    }

	    // ✅ THIS IS IMPORTANT — show cart page (NO REDIRECT)
	    req.getRequestDispatcher("/cart.jsp").forward(req, resp);
	}
	private void addItemToCart(HttpServletRequest req, Cart cart) {

	    try {
	        int itemId = Integer.parseInt(req.getParameter("itemId"));
	        int quantity = Integer.parseInt(req.getParameter("quantity"));

	        if (quantity <= 0) {
	            quantity = 1;
	        }
	        
	        MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
	        menu menu = menuDaoImpl.getMenu(itemId);

	        if (menu == null) {
	            System.out.println("Menu item not found for id: " + itemId);
	            return;
	        }

	        String itemName = menu.getItemName();
	        double itemPrice = menu.getPrice();
	        String image = menu.getImagePath();  

	        CartItem cartItem = new CartItem(itemId, itemName, itemPrice, quantity, image);

	        cart.addItem(cartItem);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	private void updateItemOfCart(HttpServletRequest req, Cart cart) {
	   int itemId=Integer.parseInt(req.getParameter("itemId"));	 
	   int quantity=Integer.parseInt(req.getParameter("quantity"));	
	   
	   cart.updateItem(itemId, quantity);
	}
	private void deleteItemFromCart(HttpServletRequest req, Cart cart) {
		   int itemId=Integer.parseInt(req.getParameter("itemId"));	 
		   cart.removeItem(itemId);
		
		
	}


	
}