package com.ibm.wenht.minibank.CustomerService.webapp.entiry;

import java.util.HashSet;
import java.util.Set;


/**
 * Class for the customer info.
 * Used for data exchanging between jsp forms and actions
 */
public class Customer {
	private String customerid;
	private String name;
	private String gender;
	private String age;
	private String address;
	private Set<Account> accountSet;

	public Customer() {
	}
	
	/**
	 * Use the passed in string to construct User object
	 */
	public Customer(String info) {
		HashSet<Account> acctSet = new HashSet<Account>();
		initialize(info, acctSet);
	}
	
	public Customer(String info, Set<Account> acctSet) {
		initialize(info, acctSet);
	}
	
	protected void initialize(String info, Set<Account> acctSet) {
		String[] parms = info.split(";");
		if ( parms.length >= 5 ) {
			customerid = parms[0];
			name = parms[1];
			gender=parms[2];
			age = parms[3];
			address = parms[4];
		}
		
		setAccountSet(acctSet);
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerID) {
		this.customerid = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String userName) {
		this.name = userName;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String userGender) {
		this.gender = userGender;
	}
	

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Account> getAccountSet() {
		return accountSet;
	}

	public void setAccountSet(Set<Account> accountSet) {
		this.accountSet = accountSet;
	}

}
