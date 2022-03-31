package com.acme.remote2;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import com.acme.remote.RemoteBean;

@Path("/testejb")
@ManagedBean
public class TestRemoteEJB {
	@EJB(mappedName="java:global/Remote1/RemoteBean")
	private RemoteBean ejb;
	
	@GET
	public String testEjb() {
		return ejb.hello("pippo");
	}
	
}
