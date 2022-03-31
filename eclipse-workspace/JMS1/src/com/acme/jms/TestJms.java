package com.acme.jms;

import javax.annotation.ManagedBean;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("testjms")
@ManagedBean
public class TestJms {
	@Inject
	private JMSContext jmsContext;
	
	@Resource(lookup="java:/TestTopic")
	private Topic topic;
	
	@GET
	public String sendMessage (@QueryParam("msg") String msg) {
		System.out.println("Sending " + msg);
		jmsContext.createProducer().send(topic, msg);
		return "ok";
	}

}
