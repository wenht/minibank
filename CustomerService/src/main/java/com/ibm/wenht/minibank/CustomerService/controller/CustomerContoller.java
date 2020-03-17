package com.ibm.wenht.minibank.CustomerService.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.wenht.minibank.CustomerService.repository.AccountRepository;
import com.ibm.wenht.minibank.CustomerService.repository.CustomerRepository;
import com.ibm.wenht.minibank.CustomerService.webapp.*;

@RestController
public class CustomerContoller {
	  @Autowired
	  private CustomerRepository customerRepository;
	  @Autowired
	  private AccountRepository accountRepository;
	  com.ibm.wenht.minibank.CustomerService.webapp.entiry.Customer user=
			  new com.ibm.wenht.minibank.CustomerService.webapp.entiry.Customer();
	  
	  @GetMapping("/{id}")
	  public com.ibm.wenht.minibank.CustomerService.webapp.entiry.Customer findUser(@PathVariable String id) {
		  com.ibm.wenht.minibank.CustomerService.entiry.Customer cust=
				  new com.ibm.wenht.minibank.CustomerService.entiry.Customer();
		  List<com.ibm.wenht.minibank.CustomerService.entiry.Account> acctList=
				  new ArrayList<com.ibm.wenht.minibank.CustomerService.entiry.Account>();
		  try {
	           cust = this.customerRepository.findById(id).get();
	           try {
	   		   acctList = this.accountRepository.findByCustomerid(cust.getCustomerid());
	           }
	           catch(Exception e) {
	        	   ;
	           }
		  }
		  catch(Exception e){
			  cust.setCustomerid("Notfound");
		  }
		  user.setCustomerid(cust.getCustomerid());
		  user.setName(cust.getName());
		  user.setAge(cust.getAge());
		  user.setGender(cust.getGender());
		  user.setAddress(cust.getAddress());
		  Set<com.ibm.wenht.minibank.CustomerService.webapp.entiry.Account> acctSet = new HashSet(acctList);
/*		  acctSet.add(new Account("A000000001;0000000001;100.00;2019-01-02 13:01:21"));
		  acctSet.add(new Account("A000000002;0000000001;200.00;2019-01-02 13:02:21"));
		  acctSet.add(new Account("A000000003;0000000001;300.00;2019-01-02 13:03:21"));
*/		  user.setAccountSet(acctSet);
		return user;
	    //return findOne;
	  }
	  @PostMapping("/")
	  public String createUser(@RequestBody com.ibm.wenht.minibank.CustomerService.webapp.entiry.Customer customer) {
		  com.ibm.wenht.minibank.CustomerService.entiry.Customer cust=
				  new com.ibm.wenht.minibank.CustomerService.entiry.Customer();
		  cust.setCustomerid(customer.getCustomerid());
		  cust.setName(customer.getName());
/*		  if(customer.getGender()==UserGender.MALE) {
			  cust.setGender("M");
		  }
		  else {
			  cust.setGender("F");
		  }
*/		  cust.setGender(customer.getGender());
		  cust.setAge(customer.getAge());
		  cust.setAddress(customer.getAddress());
		  try {
			  this.customerRepository.save(cust);
		  }
		  catch(Exception e) {
			  return "fail";
		  }
		  return "sucess";
	  }
}
