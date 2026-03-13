package com.tap.servlets;

import java.io.IOException;

import com.tap.DAOImplementation.UserDAOImp;
import com.tap.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp
    ) throws ServletException, IOException {

    	   System.out.println("Login Servlet Called");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

     

        
        UserDAOImp userDAO = new UserDAOImp();

        User user = userDAO.loginUser(email, password);

        if (user != null) {

            HttpSession session = req.getSession();
            session.setAttribute("loggedUser", user);

            resp.sendRedirect("home");

        } else {

        	req.setAttribute("error", "Invalid Email or Password");
        	
        	
        	
            RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            rd.forward(req, resp);
        }
    }
}