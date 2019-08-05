
package com.scb.guass.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

//import com.scb.guass.model.Acc;
import com.scb.guass.model.Accounts;
import com.scb.guass.model.Groups;

public class GroupRowMapper implements RowMapper<Groups> {

	@Override
	public Groups mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Groups grp=new Groups();
		grp.setGroupId(rs.getInt(1));
		grp.setGroupName(rs.getString(2));
		grp.setRateId(rs.getString(3));
		grp.setSettlementacc(rs.getInt(4));
		grp.setGroupBalance(rs.getDouble(5));
		grp.setCustomerId(rs.getInt(6));
		return grp;
	}

}
