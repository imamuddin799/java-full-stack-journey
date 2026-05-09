package org.jsp.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AnimalSound {

	@Autowired
	@Qualifier(value = "lion")
	Animal animal;
	public void doSound() {
		animal.sound();
	}
}