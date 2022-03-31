package com.acme.rest;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.validation.constraints.Min;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("greeting2")
@ApplicationScoped
public class GreetingRest2 {
	private Map<String, String> greetings = new HashMap<>();
	
	@PostConstruct
	private void init() {
		greetings.put("1", "Hello");
		greetings.put("2", "Good bye");
		greetings.put("3", "See you");
	}
	
	@GET
	@Produces("text/plain")
	public String readAll(@QueryParam("full") boolean full,
					      @QueryParam("max") @Min(1) int max) {
		System.out.printf("MAX: %d\n", max);
		return full ? greetings.toString()
				    : greetings.values().toString();
	}
	
//	@GET
//	@Produces("text/plain")
//	public String pippo (@QueryParam("max") String max)  {
//		return "pippo " + max;
//	}
	
	@GET
	@Produces("text/plain")
	@Path("{id}")
	public Response read (@PathParam("id") String id) {
		return greetings.containsKey(id) 
				? Response.ok(greetings.get(id)).build()
			    : Response.status(404).build();
	}
	
	@POST
	@Consumes("text/plain")
	@Path("{id}")
	public Response change (@PathParam("id") String id, String s) {
		if (greetings.containsKey(id)) {
			greetings.put(id, s);
			return Response.accepted("Update done").build();
		} else {
			return Response.status(404).build();
		}
	}
}
