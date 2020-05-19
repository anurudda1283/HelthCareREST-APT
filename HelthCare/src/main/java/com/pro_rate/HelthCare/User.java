package com.pro_rate.HelthCare;

public class User {

	private String userId;
	private String name;
	private String address;
	private int phone;
	private String email;
	private int card;
	private String validDate;
	private int cvcCode;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCard() {
		return card;
	}
	public void setCard(int card) {
		this.card = card;
	}
	public String getValidDate() {
		return validDate;
	}
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}
	public int getCvcCode() {
		return cvcCode;
	}
	public void setCvcCode(int cvcCode) {
		this.cvcCode = cvcCode;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", address=" + address + ", phone=" + phone + ", email="
				+ email + ", card=" + card + ", validDate=" + validDate + ", cvcCode=" + cvcCode + "]";
	}
	
	
}
