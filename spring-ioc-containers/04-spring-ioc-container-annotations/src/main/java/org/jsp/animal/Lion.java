package org.jsp.animal;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class Lion implements Animal {

	@Override
	public void sound() {
		System.out.println("Lion Sound");
	}
}