package com.scb.guass.model;

public class Accounts {
	
	
	private Long accNo;
    private String currency;
    private double balance;
    private int customerId;
    private int groupId;
	public Long getAccNo() {
		return accNo;
	}
	public void setAccNo(Long accNo) {
		this.accNo = accNo;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public Accounts(Long accNo, String currency, double balance, int customerId, int groupId) {
		super();
		this.accNo = accNo;
		this.currency = currency;
		this.balance = balance;
		this.customerId = customerId;
		this.groupId = groupId;
	}
	public Accounts() {
		super();
	}
	 	
		

	    
	}
