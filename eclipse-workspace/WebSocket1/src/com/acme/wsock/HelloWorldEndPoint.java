package com.acme.wsock;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/hello")
public class HelloWorldEndPoint {
	
	@OnMessage
	public String hello (String message, Session session) {
		System.out.println("onMessage " + message + " from " + session);
		return "Hello " + message;
	}
	
	@OnError
	public void error(Throwable t) {
		System.out.println("onError " + t);
	}
	
	@OnOpen
	public void open(Session session) {
		System.out.println("onOpen " + session);
//		Map<String, Object> prop = session.getUserProperties();
	}

	@OnClose
	public void close(Session session) {
		System.out.println("onClose " + session);
	}
}
