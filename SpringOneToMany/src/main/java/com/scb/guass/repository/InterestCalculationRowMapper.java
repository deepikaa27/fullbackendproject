package com.scb.guass.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

//import com.scb.guass.model.Acc;

import com.scb.guass.model.Groups;

public class InterestCalculationRowMapper implements RowMapper<Groups> {

	@Override
	public Groups mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Groups grp=new Groups();
		
		grp.setGroupBalance(rs.getDouble(1));
		grp.setCreditpercent(rs.getDouble(2));
		grp.setDebitpercent(rs.getDouble(3));
		
		return grp;
	}

}
