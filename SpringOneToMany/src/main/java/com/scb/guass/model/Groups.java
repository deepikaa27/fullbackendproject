package com.scb.guass.model;

import java.util.ArrayList;
import java.util.List;
public class Groups {
	
	private int groupId;
	private String groupName;
	private String rateId;
	private int settlementacc;
	private double groupBalance;
	private int customerId;
	private double creditpercent;
	private double debitpercent;
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getRateId() {
		return rateId;
	}
	public void setRateId(String rateId) {
		this.rateId = rateId;
	}
	public int getSettlementacc() {
		return settlementacc;
	}
	public void setSettlementacc(int settlementacc) {
		this.settlementacc = settlementacc;
	}
	public double getGroupBalance() {
		return groupBalance;
	}
	public void setGroupBalance(double groupBalance) {
		this.groupBalance = groupBalance;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public double getCreditpercent() {
		return creditpercent;
	}
	public void setCreditpercent(double creditpercent) {
		this.creditpercent = creditpercent;
	}
	public double getDebitpercent() {
		return debitpercent;
	}
	public void setDebitpercent(double debitpercent) {
		this.debitpercent = debitpercent;
	}
	public Groups(int groupId, String groupName, String rateId, int settlementacc, double groupBalance, int customerId,
			double creditpercent, double debitpercent) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.rateId = rateId;
		this.settlementacc = settlementacc;
		this.groupBalance = groupBalance;
		this.customerId = customerId;
		this.creditpercent = creditpercent;
		this.debitpercent = debitpercent;
	}
	public Groups() {
		super();
	}
	@Override
	public String toString() {
		return "Groups [groupId=" + groupId + ", groupName=" + groupName + ", rateId=" + rateId + ", settlementacc="
				+ settlementacc + ", groupBalance=" + groupBalance + ", customerId=" + customerId + ", creditpercent="
				+ creditpercent + ", debitpercent=" + debitpercent + "]";
	}
	

}

