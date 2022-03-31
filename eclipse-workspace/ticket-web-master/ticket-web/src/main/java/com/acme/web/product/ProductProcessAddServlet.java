package com.acme.web.product;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acme.model.Product;
import com.acme.model.ProductManager;

@WebServlet("/product/process-add")
public class ProductProcessAddServlet extends HttpServlet {
	@Inject
	private ProductManager pm;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		
		Product product = new Product(name, Double.parseDouble(price));
		pm.addProduct(product);
		
		resp.sendRedirect("/ticket-web/product/");
//		req.getRequestDispatcher("/product/").forward(req, resp);
	}
}
