package com.acme.rest;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("greeting")
@ApplicationScoped
public class GreetingRest {
	private String s = "Hello world!\n";
	
	@PostConstruct
	private void init() {
		System.out.printf("%s postconstruct\n", this);
	}
	
	@PreDestroy
	private void destroy() {
		System.out.printf("%s predestroy\n", this);
	}
	
	@GET
	@Produces("text/plain")
	public String read() {
		System.out.printf("%s read\n", this);
		return s;
	}
	
	@POST
	@Consumes("text/plain")
	public Response change (String s) {
		System.out.printf("%s change: %s\n", this, s);
		this.s = s;
		
		return Response.accepted("Update done").build();
	}
}
