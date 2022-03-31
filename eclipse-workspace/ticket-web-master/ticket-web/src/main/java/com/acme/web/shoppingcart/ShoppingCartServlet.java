package com.acme.web.shoppingcart;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acme.model.ShoppingCartManager;

@WebServlet("/shopping-cart/")
public class ShoppingCartServlet extends HttpServlet {
	@Inject
	private ShoppingCartManager shm;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
		req.setAttribute("products", shm.getAllProducts());
		req.getRequestDispatcher("ShoppingCart.jsp").forward(req, resp);
	}
}
