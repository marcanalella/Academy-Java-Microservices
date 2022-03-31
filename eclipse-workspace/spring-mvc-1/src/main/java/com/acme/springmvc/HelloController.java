package com.acme.springmvc;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	private final HelloService helloService;
	
	@Inject
	public HelloController (HelloService helloService) {
		this.helloService = helloService;
	}
	
	@GetMapping(path="/")
	public ModelAndView hello(
			@RequestParam(name="aParam",defaultValue="paperino") String aParam) {
		String message = helloService.sayHello(aParam);
		System.out.println(message);
		ModelAndView mav = new ModelAndView("hello.jsp");
		mav.addObject("message", message);
		return mav;
	}	
	
	@GetMapping(path="/resttest", produces="application/xml")
	@ResponseBody
	public Car helloRest() {
		return new Car("Audi", "A3");
	}
	
}
