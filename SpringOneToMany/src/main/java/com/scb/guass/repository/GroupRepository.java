package com.scb.guass.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.scb.guass.model.Accounts;
import com.scb.guass.model.Customer;
import com.scb.guass.model.Groups;

@Repository
public class GroupRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private ResultSet rs = null;
	public static List<Accounts> list = new ArrayList<Accounts>();
	public static List<Customer> list1 = new ArrayList<Customer>();
	public static List<Groups> list2 = new ArrayList<Groups>();
	
    
	@Autowired
	public GroupRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public final static RowMapper<Groups> orderMapper = BeanPropertyRowMapper.newInstance(Groups.class);// .newInstance(Order.class);
	public final static RowMapper<Accounts> lineItemMapper = BeanPropertyRowMapper.newInstance(Accounts.class);
	public final static RowMapper<Customer> lineItemMapper1 = BeanPropertyRowMapper.newInstance(Customer.class);
	

	
	/*
	 * public Groups findOrderWithItems(Long Id) { return jdbcTemplate.
	 * query("select accountnumber from accounts where groupid in(select groupid from groups where customerid=?)"
	 * , new ResultSetExtractor<Groups>() { public Groups extractData(ResultSet rs)
	 * throws SQLException, DataAccessException { Groups order = null; int row = 0;
	 * while (rs.next()) { if (order == null) { order = orderMapper.mapRow(rs, row);
	 * } order.addItem(lineItemMapper.mapRow(rs, row)); row++; } return order; }
	 * 
	 * }, Id); }
	 */

	public int add(Groups grp) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO \"groups\" (groupid,groupname,rateid,customerid) VALUES(?,?,?,?)";
		return jdbcTemplate.update(query,
				new Object[] { grp.getGroupId(), grp.getGroupName(), grp.getRateId(), grp.getCustomerId()

				});
	}

	public int update(Accounts acc) {
		String query = "UPDATE \"accounts\" SET groupid = ? where accountnumber=?";
		int row = jdbcTemplate.update(query, acc.getGroupId(), acc.getAccNo());
		System.out.println(acc.getGroupId());
		return row;
	}

	public int update(Groups grp) {
		String query = "UPDATE \"groups\" SET groupbalance = ?, rateid=? where groupid=?";
		int row = jdbcTemplate.update(query, grp.getGroupBalance(), grp.getRateId(), grp.getGroupId());
		System.out.println(grp.getGroupId());
		System.out.println(grp.getGroupBalance());
		System.out.println(grp.getRateId());
		return row;
	}

	public List<Accounts> findOrderWithItem(Long Id) {
		String sql = "select * from \"accounts\" where accountnumber=?";
		RowMapper<Accounts> acc = new AccountRowMapper();
		list = this.jdbcTemplate.query(sql, acc, Id);
		return list;

	}

	List<Accounts> acc = new ArrayList<Accounts>();

	public List<Accounts> findAllOrderWithItems(Long Id) {
		/*
		 * return jdbcTemplate.query("select * from accounts where customerid=?",
		 * 
		 * new ResultSetExtractor<List<Groups>>() { public List<Groups>
		 * extractData(ResultSet rs) throws SQLException, DataAccessException {
		 * List<Groups> orders = new ArrayList<Groups>(); Long orderId = null; Groups
		 * currentOrder = null; int orderIdx = 0; int itemIdx = 0; while (rs.next()) {
		 * // first row or when order changes if (currentOrder == null ||
		 * !orderId.equals(rs.getLong("customerid"))) { orderId =
		 * rs.getLong("customerid"); currentOrder = orderMapper.mapRow(rs, orderIdx++);
		 * itemIdx = 0; orders.add(currentOrder); }
		 * currentOrder.addItem(lineItemMapper.mapRow(rs, itemIdx++)); } return orders;
		 * }
		 * 
		 * }); }
		 */
		String sql = "select * from accounts where customerid=?";
		RowMapper<Accounts> rowmapper = new AccountRowMapper();

		acc = this.jdbcTemplate.query(sql, rowmapper, Id);
		return acc;

	}

	List<Groups> grp = new ArrayList<Groups>();

	public List<Groups> findAllOrderWithItems1(Long Id) {
		String sql = "select * from groups where customerid=?";
		RowMapper<Groups> rowmapper = new GroupRowMapper();

		grp = this.jdbcTemplate.query(sql, rowmapper, Id);
		return grp;

	}
	public List<Customer> findOrderWithItems2(Long Id) {
		String sql = "select * from \"customer\" where customerid=?";
		RowMapper<Customer> stud = new CustomerRowMapper();
		list1 = this.jdbcTemplate.query(sql, stud, Id);
		return list1;

	}
	public List<Groups> findOrderWithItem1(Long Id) {
		String sql1 = "select * from \"groups\" where groupid=?";
		RowMapper<Groups> grp = new GroupRowMapper();
		list2 = this.jdbcTemplate.query(sql1,grp, Id);
		return list2;

	}
	List<Customer> stud = new ArrayList<Customer>();

	public List<Customer> findAllCustomer() {
		String sql = "select * from \"customer\"";
		RowMapper<Customer> rowmapper = new CustomerRowMapper();

		stud = this.jdbcTemplate.query(sql, rowmapper);
		return stud;

	}
	  
	  public boolean calculateAccountBalance1(int id) {
		  
		  String sql = "select SUM(balance) from \"accounts\" where \"groupid\"=?";
		  RowMapper<Double> rowmapper = new DoubleRowMapper(); 
		  
		  List<Double> acc=this.jdbcTemplate.query(sql, rowmapper,id);
		  
		  Iterator<Double> itr=acc.iterator();
		  while(itr.hasNext())
		  {
			  System.out.println(itr.next());
		  }
		  
	      return true;
		  
		  }
	  public int updatebalance(Groups grp) {
			String query = "UPDATE \"groups\" SET groupbalance = ? rateid=? where groupid=?";
			int row = jdbcTemplate.update(query, grp.getGroupBalance(),grp.getRateId(), grp.getGroupId());
			System.out.println(grp.getGroupId());
			System.out.println(grp.getRateId());
			System.out.println(grp.getGroupBalance());
			return row;
		}
	
	  List<Groups> grp1 = new ArrayList<Groups>(); 
	 static List<Accounts> acc1 = new ArrayList<Accounts>(); 
	  public double calculateInterest(int id,Groups grp1,Accounts acc1) 
	  { 
		  double interest; 
		  double totalbalance=0;
	      
	      String sql1="select groupbalance from \"groups\" where groupid=?";
	      RowMapper<Double> rowmapper = new DoubleRowMapper();
	      double groupbalance=this.jdbcTemplate.queryForObject(sql1,rowmapper,id);
	      String sql2="select creditpercent from \"groups\" where groupid=?";
	      double creditpercent=this.jdbcTemplate.queryForObject(sql2,rowmapper,id);
	      String sql3="select debitpercent from \"groups\" where groupid=?";  
	      double debitpercent=this.jdbcTemplate.queryForObject(sql3,rowmapper,id);
          RowMapper<String> rowmapper1=new StringRowMapper();
          String sql4="select rateid from \"groups\" where groupid=?";  
	      String rateid=this.jdbcTemplate.queryForObject(sql4,rowmapper1,id);
	      Iterator<Groups> itr=grp.iterator(); 
	      while(itr.hasNext()) 
	      {
	      System.out.println(itr.next()); 
	      }
	      System.out.println("rateid"+rateid);
	      double groupid=id;
	      if(rateid.equals("r001"))
	      {
	    	 
	        if(groupbalance>0 )
	        {
	          System.out.println("credit:"+creditpercent);
	          interest=(groupbalance*creditpercent)/(365*100);
	          System.out.println("interest:"+interest);
	          totalbalance=groupbalance+interest;
	          System.out.println("Total balance:"+totalbalance);
	        
	          System.out.println("groupid"+groupid);
	          RowMapper<Double> rowmapper3=new DoubleRowMapper();
	          
	          //String sql5="select settlementacc from \"groups\" where groupid=?";  
		      //Double settlementacc=this.jdbcTemplate.queryForObject(sql5,rowmapper3,id);	      
	        }
	        
	        else
	        {
	    	  interest=(groupbalance*debitpercent)/(365*100);
	    	  System.out.println("interest:"+interest);
	    	  totalbalance=groupbalance+interest;
	    	  System.out.println("Total balance:"+totalbalance);
	         }
	        
	       }
	      if(rateid.equals("r002"))
	      {
	    	  if(groupbalance>0 && groupbalance<10000)
	    	  {
	    	  System.out.println("credit:"+creditpercent);
	          interest=(groupbalance*creditpercent)/(365*100);
	          System.out.println("interest:"+interest);
	          totalbalance=groupbalance+interest;
	          System.out.println("Total balance:"+totalbalance); 
	    	  }
	    	  else
		        {
		    	  interest=(groupbalance*debitpercent)/(365*100);
		    	  System.out.println("interest:"+interest);
		    	  totalbalance=groupbalance+interest;
		    	  System.out.println("Total balance:"+totalbalance);
		         }
	      }
	      if(rateid.equals("r003"))
	      {
	    	  if(groupbalance>10000 && groupbalance<30000)
	    	  {
	    	  System.out.println("credit:"+creditpercent);
	          interest=(groupbalance*creditpercent)/(365*100);
	          System.out.println("interest:"+interest);
	          totalbalance=groupbalance+interest;
	          System.out.println("Total balance:"+totalbalance);
	    	  }
	    	  else
		        {
		    	  interest=(groupbalance*debitpercent)/(365*100);
		    	  System.out.println("interest:"+interest);
		    	  totalbalance=groupbalance+interest;
		    	  System.out.println("Total balance:"+totalbalance);
		         }
	      }
	      if(rateid.equals("r004"))
	      {
	    	  if(groupbalance>30000 && groupbalance<100000)
	    	  {
	    	  System.out.println("credit:"+creditpercent);
	          interest=(groupbalance*creditpercent)/(365*100);
	          System.out.println("interest:"+interest);
	          totalbalance=groupbalance+interest;
	          System.out.println("Total balance:"+totalbalance);
	    	  }
	    	  else
		        {
		    	  interest=(groupbalance*debitpercent)/(365*100);
		    	  System.out.println("interest:"+interest);
		    	  totalbalance=groupbalance+interest;
		    	  System.out.println("Total balance:"+totalbalance);
		         }
	      }
	      if(rateid.equals("r005"))
	      {
	    	  if(groupbalance>100000)
	    	  {
	    	  System.out.println("credit:"+creditpercent);
	          interest=(groupbalance*creditpercent)/(365*100);
	          System.out.println("interest:"+interest);
	          totalbalance=groupbalance+interest;
	          System.out.println("Total balance:"+totalbalance);
	    	  }
	    	  else
		        {
		    	  interest=(groupbalance*debitpercent)/(365*100);
		    	  System.out.println("interest:"+interest);
		    	  totalbalance=groupbalance+interest;
		    	  System.out.println("Total balance:"+totalbalance);
		        }
	      }
	      String sql6="update \"groups\" set groupbalance=? where groupid=?";
		  int row = jdbcTemplate.update(sql6,totalbalance,groupid);
		  System.out.println("number of rows updated:"+row);
		  String sql7="select settlementacc from \"groups\" where groupid=?";
		  RowMapper<Double> rowmapper5 = new DoubleRowMapper();
	      double settlementacc=this.jdbcTemplate.queryForObject(sql7,rowmapper5,id);
		  String sql8="update \"accounts\" set balance=? where accountnumber=?";
		  int row2 = jdbcTemplate.update(sql8,totalbalance,settlementacc);
		  System.out.println("number of rows updated:"+row2);
	  return totalbalance;
	  
	  }
	 
	  
	
}





