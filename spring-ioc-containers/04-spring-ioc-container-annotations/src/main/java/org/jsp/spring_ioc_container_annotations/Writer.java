package org.jsp.spring_ioc_container_annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Writer {

	@Value (value = "Imamuddin Ansari")
	String name;
	
	@Value (value = "22")
	int age;
	
	@Value (value = "Bihar")
	String address;
	
	@Autowired
	Pen pen;
	
	public void writerDetails() {
		System.out.println(name);
		System.out.println(age);
		System.out.println(address);
		pen.penDetails();
	}
}