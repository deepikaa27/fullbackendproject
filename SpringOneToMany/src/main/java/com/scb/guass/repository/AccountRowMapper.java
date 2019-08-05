package com.scb.guass.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.scb.guass.model.Acc;
import com.scb.guass.model.Accounts;

public class AccountRowMapper implements RowMapper<Accounts> {

	@Override
	public Accounts mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Accounts acc=new Accounts();
		acc.setAccNo(rs.getLong(1));
		acc.setGroupId(rs.getInt(5));
		acc.setCurrency(rs.getString(2));
		acc.setBalance(rs.getDouble(3));
		acc.setCustomerId(rs.getInt(4));
		return acc;
		
	}

}
