package com.acme.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(
		activationConfig = { 
				@ActivationConfigProperty(propertyName = "destination", 
										  propertyValue = "java:/TestTopic"), 
				@ActivationConfigProperty(propertyName = "destinationType", 
								          propertyValue = "javax.jms.Topic")
		}, 
		mappedName = "java:/TestTopic")
//@TransactionAttribute
public class TestMessageReceiver2 {

    public void onMessage(Message message) {
    	try {
			String msg = message.getBody(String.class);
			System.out.println("Recv 2 " + msg);
		} catch (JMSException e) {
			e.printStackTrace();
		}
    }
}
