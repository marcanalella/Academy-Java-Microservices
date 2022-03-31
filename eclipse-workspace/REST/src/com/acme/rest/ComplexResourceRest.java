package com.acme.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("cr")
public class ComplexResourceRest {
	@GET
	@Produces( { MediaType.APPLICATION_XML, 
				 MediaType.APPLICATION_JSON,
				 MediaType.TEXT_PLAIN } )
	public ComplexResource get() {
		return new ComplexResource(1, "pluto", "pippo");
	}
	
	@GET
	@Produces("text/boh")
	public String getAsText() {
		ComplexResource cr = new ComplexResource(1, "pluto", "pippo");
		return String.format("CR: %s %s %s", cr.getI(), cr.getS1(), cr.getS2());
	}
}
