package com.scb.guass.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.scb.guass.model.Interest;

public class InterestRowMapper implements RowMapper<Interest> {

	@Override
	public Interest mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Interest intr=new Interest();
		intr.setRateId(rs.getString(1));
		intr.setInterestType(rs.getString(2));
		intr.setCreditPercent(rs.getInt(3));
		intr.setDebitPercent(rs.getInt(4));
		return intr;
	}

}
