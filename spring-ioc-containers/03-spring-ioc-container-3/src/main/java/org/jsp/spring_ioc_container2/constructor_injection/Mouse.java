package org.jsp.spring_ioc_container2.constructor_injection;

public class Mouse {

    private String buttonType;         // e.g., mechanical, optical, laser
    private int numberOfButtons;
    private String scrollType;         // e.g., touch, wheel
    
	public Mouse(String buttonType, int numberOfButtons, String scrollType) {
		this.buttonType = buttonType;
		this.numberOfButtons = numberOfButtons;
		this.scrollType = scrollType;
	}

	public String mouseDetails() {
		return "[buttonType = " + buttonType + ", numberOfButtons = " + numberOfButtons + ", scrollType = " + scrollType
				+ "]";
	}
}