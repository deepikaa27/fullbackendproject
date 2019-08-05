
package com.scb.guass.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.scb.guass.model.Acc;
import com.scb.guass.model.Accounts;
import com.scb.guass.model.Customer;
import com.scb.guass.model.Groups;


public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Customer stud=new Customer();
		stud.setCustomerId(rs.getInt(1));
		stud.setCorporateName(rs.getString(2));
		stud.setEmail(rs.getString(3));
		stud.setMobile(rs.getLong(4));
		
		return stud;
	}

}
