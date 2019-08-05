package com.scb.guass.model;

public class Interest {
private String rateId;
private String interestType;
private int creditPercent;
private int debitPercent;
public Interest(String rateId, String interestType, int creditPercent, int debitPercent) {
	super();
	this.rateId = rateId;
	this.interestType = interestType;
	this.creditPercent = creditPercent;
	this.debitPercent = debitPercent;
}
public Interest() {
	super();
}
public String getRateId() {
	return rateId;
}
public void setRateId(String rateId) {
	this.rateId = rateId;
}
public String getInterestType() {
	return interestType;
}
public void setInterestType(String interestType) {
	this.interestType = interestType;
}
public int getCreditPercent() {
	return creditPercent;
}
public void setCreditPercent(int creditPercent) {
	this.creditPercent = creditPercent;
}
public int getDebitPercent() {
	return debitPercent;
}
public void setDebitPercent(int debitPercent) {
	this.debitPercent = debitPercent;
}
@Override
public String toString() {
	return "Interest [rateId=" + rateId + ", interestType=" + interestType + ", creditPercent=" + creditPercent
			+ ", debitPercent=" + debitPercent + "]";
}



}
