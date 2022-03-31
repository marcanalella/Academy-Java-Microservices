package com.acme.web;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.acme.model.Product;
import com.acme.model.ProductManager;

@Controller
public class ProductController {
	private final ProductManager pm;
	
	@Inject
	public ProductController (ProductManager pm) {
		this.pm = pm;
	}

	@GetMapping(path="/product/")
	public ModelAndView renderAllProducts() {
		List<Product> products = pm.getAllProducts();
		ModelAndView mav = new ModelAndView("/product/ProductList.jsp");
		mav.addObject("products", products);
		
		return mav;
	}
	
	@GetMapping(path="/product/add/")
	public String addProduct() {
		return "/product/AddProduct.jsp";
	}
	
	@PostMapping(path="/product/process-add/")
	public String processAddProduct(
			@RequestParam("name") String name,
			@RequestParam("price") double price) {
		pm.addProduct(new Product(name, price));
		return "redirect:/product/";
	}
}
