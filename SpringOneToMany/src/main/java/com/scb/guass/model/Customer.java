package com.scb.guass.model;
import java.util.ArrayList;
public class Customer {
	private int customerId;
	private String corporateName;
	private String email;
	private long mobile;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCorporateName() {
		return corporateName;
	}
	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public Customer(int customerId, String corporateName, String email, long mobile) {
		super();
		this.customerId = customerId;
		this.corporateName = corporateName;
		this.email = email;
		this.mobile = mobile;
	}
	public Customer() {
		super();
	}
	@Override
	public String toString() {
		return "Student [customerId=" + customerId + ", corporateName=" + corporateName + ", email=" + email
				+ ", mobile=" + mobile + "]";
	}
	
}
