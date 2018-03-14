
package com.telus.Sender;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import common.Message;

@SpringBootApplication
@EnableJms
public class Application {

	public static void main(String[] args) {
		// Launch the application
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

		//		Send a message with a POJO - the template reuse the message converter
		System.out.println("Sending");
		long starttime = System.currentTimeMillis();
		try{
			send1m(jmsTemplate);
		}catch(JmsException e){
			System.out.println("No connection");
		}catch (Exception e){
			System.out.println("Unexpected exception is: " + e.getMessage());
		}

		System.out.format("Done in %d ms%n", System.currentTimeMillis()-starttime);
		context.close();
		//		System.out.println(new Message("info@example.com", "Hello").toString());
		//		jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello1"));
		//		jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello2"));
		//		jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello3"));
		//		jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello4"));
		//		jmsTemplate.convertAndSend("stringbox", "String test 1");
	}

	private static void send1m(JmsTemplate jmsTemplate) throws JmsException{
		for(int i = 0; i<2;i++){
			jmsTemplate.convertAndSend("msgbox", new Message("khalid.khan2@telus.com", "Msg# "+i));
		}
	}

	@Bean // Serialize message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
}
