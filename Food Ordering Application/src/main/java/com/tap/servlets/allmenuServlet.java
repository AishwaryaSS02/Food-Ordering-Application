package com.tap.servlets;

import java.io.IOException;
import java.util.List;

import com.tap.DAOImplementation.MenuDaoImpl;
import com.tap.model.menu;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/all-menus")
public class allmenuServlet extends HttpServlet{

	

	
	    @Override
	    protected void service(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {

	        MenuDaoImpl dao = new MenuDaoImpl();
	        List<menu> allMenus = dao.getAllMenu();

	        req.setAttribute("menuList", allMenus);

	        // Remove specific restaurantId from session if needed
	        req.getSession().removeAttribute("restaurantId");

	        req.getRequestDispatcher("menu.jsp").forward(req, resp);
	    
	}

}
