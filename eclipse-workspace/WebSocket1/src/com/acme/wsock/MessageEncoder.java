package com.acme.wsock;

import java.io.IOException;
import java.io.Writer;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageEncoder implements Encoder.TextStream<Message> {

	@Override
	public void destroy() {}

	@Override
	public void init(EndpointConfig arg0) {}

	@Override
	public void encode(Message msg, Writer w) 
			throws EncodeException, IOException {
		w.write("{ ");
		w.write("'name':'" + msg.getUserName() + "',");
		w.write("'message':'" + msg.getMessage() + "'");
		w.write(" }");
	}
}
