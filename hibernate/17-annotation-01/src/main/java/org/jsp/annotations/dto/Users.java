package org.jsp.annotations.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_details")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int uid;
	
	@Column(name = "user_name")
	private String uname;
	
	@Column(nullable = false)
	private String address;
	
	@Column(name = "email_id", unique = true)
	private String email;
	
//	@NotNull
	@Column(nullable = false, unique = true)
	private long mno;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

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
		return "Users [uid = " + uid + ", uname = " + uname + ", address = " + address + ", email = " + email
				+ ", mno = " + mno + "]";
	}
}