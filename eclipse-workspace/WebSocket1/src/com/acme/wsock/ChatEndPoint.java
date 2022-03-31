package com.acme.wsock;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chat/{userName}", encoders = MessageEncoder.class)
public class ChatEndPoint {
	
	@OnOpen
	public void login(@PathParam("userName") String userName, Session session) {
		session.getUserProperties().put("name", userName);
		System.out.println("Logged in " + userName);
		
//		for (Session s : session.getOpenSessions()) {
//			s.getAsyncRemote().sendText("Logged in " + userName);
//		}
	}

//	@OnMessage
//	public void dispatch (String message, Session session) {
//		String name = (String)session.getUserProperties().get("name");
//		
//		for (Session s : session.getOpenSessions()) {
//			s.getAsyncRemote().sendText(name + ": " + message);
//		}
//	}
	@OnMessage
	public void dispatch (String message, Session session) {
		String name = (String)session.getUserProperties().get("name");
		
		for (Session s : session.getOpenSessions()) {
			s.getAsyncRemote().sendObject(new Message(name, message));
		}
	}
}
