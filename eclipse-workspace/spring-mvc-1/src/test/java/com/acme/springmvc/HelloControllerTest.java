package com.acme.springmvc;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import com.acme.springmvc.impl.DefaultHelloService;

public class HelloControllerTest {
	
	@Test
	public void test1() {
		// GIVEN
		HelloService helloService = new DefaultHelloService();
		HelloController underTest = new HelloController(helloService);
		// WHEN
		ModelAndView mav = underTest.hello("Pluto");
		// THEN
		assertEquals("hello.jsp", mav.getViewName());
		assertEquals("Hello Pluto", mav.getModelMap().get("message"));
	}
}
