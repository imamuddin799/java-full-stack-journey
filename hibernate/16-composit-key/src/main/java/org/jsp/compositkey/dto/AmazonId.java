package org.jsp.compositkey.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class AmazonId implements Serializable {

	private String email;
	private long mno;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMno() {
		return mno;
	}
	public void setMno(long mno) {
		this.mno = mno;
	}
	
	@Override
	public String toString() {
		return "AmazonId [email = " + email + ", mno = " + mno + "]";
	}
}