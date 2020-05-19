package com.pro_rate.HelthCare;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Hospital {

	private String registerId;
	private String name;
	private String type;
	private String address;
	private int phone;
	
	public Hospital(){}

	public String getRegisterId() {
		return registerId;
	}

	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Hospital [registerId=" + registerId + ", name=" + name + ", type=" + type + ", address=" + address
				+ ", phone=" + phone + "]";
	}
	
	
	
}
