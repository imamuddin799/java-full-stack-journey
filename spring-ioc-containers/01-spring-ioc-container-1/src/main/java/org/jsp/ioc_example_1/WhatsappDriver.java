package org.jsp.ioc_example_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WhatsappDriver {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("whatsapp.xml");
		Whatsapp whatsapp = (Whatsapp) context.getBean("whatsapp");
		whatsapp.sendMessage("I am sending message to someone");
		whatsapp.receiveMessage("I am receiving message from someone");
		whatsapp.joinVideoCall("This is a video call from someone");
		whatsapp.joinAudeoCall("This is a Audeo call from someone");
	}
}