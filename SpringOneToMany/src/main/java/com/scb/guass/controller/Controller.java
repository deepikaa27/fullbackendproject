package com.scb.guass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.scb.guass.model.Acc;
import com.scb.guass.model.Accounts;
import com.scb.guass.model.Groups;
import com.scb.guass.model.Customer;
import com.scb.guass.repository.GroupRepository;


@RequestMapping("group")

@RestController
public class Controller {
	
	@Autowired
	GroupRepository custRes;
	
	
	/* adding a resource*/
	
	@PostMapping("/add")
	private int add(@RequestBody Groups grp) {
		return custRes.add(grp);
	}

	/* updating a resource*/
	
	@PutMapping("/update")
	private int update(@RequestBody Accounts acc) {
		return custRes.update(acc);
	}
	
	/* updating a group based on group id*/
	  @PutMapping("/updategroup") 
	  private int update(@RequestBody Groups grp) 
	  { 
		  return custRes.update(grp); 
		  }
	  
		
	/* displaying all the accounts based on customer id */
	@RequestMapping("/findall/{id}")
	public List<Accounts> findAll(@PathVariable Long id)
	{
		return custRes.findAllOrderWithItems(id);
		
	}
	
	/*display all the groups based on customer id*/
	@RequestMapping("/findallgroup/{id}")
	public List<Groups> findAll1(@PathVariable Long id)
	{
		return custRes.findAllOrderWithItems1(id);
		
	}
	
	/*display account summary based on account number*/
	@RequestMapping("/find/{id}")
	public List<Accounts> find(@PathVariable Long id)
	{
		return custRes.findOrderWithItem(id);
		
	}
	
	/* display the customer details based on customer id*/
	@RequestMapping("/findcustomer/{id}")
	public List<Customer> find2(@PathVariable Long id)
	{
		return custRes.findOrderWithItems2(id);
		
	}
	/*display the group summary based on group id*/
	@RequestMapping("/findgroup/{id}")
	public List<Groups> find1(@PathVariable Long id)
	{
		return custRes.findOrderWithItem1(id);
		
	}
	/*display all customers*/
	@RequestMapping("/findallcustomer")
	public List<Customer> findAll1()
	{
		return custRes.findAllCustomer();
		
	}
	@RequestMapping("/calculatebalance/{id}")
	public boolean calculateBalance(@PathVariable int id)
	{
		return custRes.calculateAccountBalance1(id);
		
	}
	/* updating a group based on group id*/
	  @PutMapping("/updategroupbalance") 
	private int updatebalance(@RequestBody Groups grp) 
	{ 
		  return custRes.update(grp); 
     }
	  @RequestMapping("/calculateinterest/{id}")
	public double calculateGroupInterest(@PathVariable int id,@RequestBody Groups grp1, Accounts acc1)
	{
			return custRes.calculateInterest(id, grp1,acc1);
			
		}
}
