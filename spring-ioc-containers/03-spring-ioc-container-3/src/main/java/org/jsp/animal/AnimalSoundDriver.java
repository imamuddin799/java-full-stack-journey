package org.jsp.animal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalSoundDriver {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("animal_sound.xml");
		AnimalSound animalSoundlion = (AnimalSound) context.getBean("animalsoundlion");
		animalSoundlion.doSound();
		
		AnimalSound animalSounddog = (AnimalSound) context.getBean("animalsounddog");
		animalSounddog.doSound();
		
		ClassPathXmlApplicationContext xmlApplicationContext = (ClassPathXmlApplicationContext) context;
		xmlApplicationContext.close();
	}
}