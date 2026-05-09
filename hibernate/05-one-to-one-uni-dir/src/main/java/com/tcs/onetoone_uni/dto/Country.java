package com.tcs.onetoone_uni.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Country {

	@Id
	private int cid;
	private String name;
	private int code;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Capital capital;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Capital getCapital() {
		return capital;
	}

	public void setCapital(Capital capital) {
		this.capital = capital;
	}

	@Override
	public String toString() {
		return "Country [cid = " + cid + ", name = " + name + ", code = " + code + ", capital = " + capital + "]";
	}
}