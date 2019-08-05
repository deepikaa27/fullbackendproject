package com.scb.guass.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DoubleRowMapper implements RowMapper<Double> {

	@Override
	public Double mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return rs.getDouble(1);
	}

}
