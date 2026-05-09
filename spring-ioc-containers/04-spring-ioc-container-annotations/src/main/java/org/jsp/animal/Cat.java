package org.jsp.animal;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class Cat implements Animal {

	@Override
	public void sound() {
		System.out.println("Cat Sound");
	}

}
