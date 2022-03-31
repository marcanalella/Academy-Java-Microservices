package com.acme.web.product;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acme.model.Product;
import com.acme.model.ProductManager;

@WebServlet("/product/")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private ProductManager pm; // TODO: final?
	
	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) 
		throws ServletException, IOException {
		System.out.println("pm class = " + pm.getClass());
		List<Product> products = pm.getAllProducts();
		
		RequestDispatcher rd = request.getRequestDispatcher("ProductList.jsp");
		request.setAttribute("products", products);
		rd.forward(request, response);
	}

}
