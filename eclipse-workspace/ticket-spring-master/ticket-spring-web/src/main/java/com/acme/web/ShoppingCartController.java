package com.acme.web;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;
import com.acme.model.BuyManager;
import com.acme.model.ShoppingCartManager;

@Controller
@SessionScope
public class ShoppingCartController {
	private final ShoppingCartManager shm;
	private final BuyManager bm;
	
	@Inject
	public ShoppingCartController (ShoppingCartManager shm, BuyManager bm) {
		this.shm = shm;
		this.bm = bm;
		System.out.println("NEW SH CONTROLLER");
	}
	
	@GetMapping(path="/shopping-cart/")
	public ModelAndView renderShoppingCart() {
		final ModelAndView mav = new ModelAndView("/shopping-cart/ShoppingCart.jsp");
		mav.addObject("products", shm.getAllProducts());
		return mav;
	}
	
	@PostMapping(path="/shopping-cart/add/")
	public String buy(@RequestParam("id") String id) {
		bm.buyProduct(id);
		return "redirect:/shopping-cart/";
	}

}
