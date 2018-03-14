package com.telus.Reciever;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import common.Message;

@Component
public class Receiver {
	private final long recieved = 0;

	//	@JmsListener(destination = "mailbox", containerFactory = "myFactory")
	//	public void receiveMessage(Email email) {
	//		System.out.println("Received Email <" + email + ">");
	//	}

	@JmsListener(destination = "msgbox", containerFactory = "myFactory")
	public void receiveMessage(Message msg) {
		System.out.printf("Received Message <%s> total time %d ms%n", msg, System.currentTimeMillis() - msg.getSentTime());
		//		recieved++;

	}

	//	@JmsListener(destination = "stringbox", containerFactory = "myFactory")
	//	public void receiveMessage(String str) {
	//		System.out.println("Received String'" + str + "'");
	//	}

}
