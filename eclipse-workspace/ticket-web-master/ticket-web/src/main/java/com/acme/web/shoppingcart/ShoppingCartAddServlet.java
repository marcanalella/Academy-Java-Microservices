package com.acme.web.shoppingcart;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.acme.model.BuyManager;
import com.acme.model.Product;

@WebServlet("/shopping-cart/add")
public class ShoppingCartAddServlet extends HttpServlet {
	
	@Inject
	private BuyManager bm;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id = req.getParameter("id");
		bm.buyProduct(id);
		resp.sendRedirect("/ticket-web/shopping-cart/");
	}
}
