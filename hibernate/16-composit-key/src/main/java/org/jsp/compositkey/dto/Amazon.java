package org.jsp.compositkey.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Amazon {

	private String name;
	private String password;
	private String address;
	
	@EmbeddedId
	private AmazonId amazonId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AmazonId getAmazonId() {
		return amazonId;
	}

	public void setAmazonId(AmazonId amazonId) {
		this.amazonId = amazonId;
	}

	@Override
	public String toString() {
		return "Amazon [name = " + name + ", password = " + password + ", address = " + address + ", amazonId = "
				+ amazonId + "]";
	}
}