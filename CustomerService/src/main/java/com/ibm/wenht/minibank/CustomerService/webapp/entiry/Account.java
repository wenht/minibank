package com.ibm.wenht.minibank.CustomerService.webapp.entiry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class for the account info.
 * Used for data exchanging between jsp forms and actions.
 */
public class Account {
	private String accountnumber;
	private String customerid;
	private String balance;
	private String lastchangetime;
	
	public Account() {
	}
	
	/**
	 * Use the passed in string to construct Account object
	 */
/*	public Account(String acctInfo) {
		HashSet<TransHistory> tranHist = new HashSet<TransHistory>();
		initialize(acctInfo, tranHist);
	}
*/

	public Account(String acctInfo) {
		initialize(acctInfo);
	}
	
	protected void initialize(String acctInfo) {
		String[] parms = acctInfo.split(";");
		if ( parms.length >= 4 ) {
			accountnumber = parms[0];
			customerid = parms[1];
			balance = parms[2];
			lastchangetime = parms[3];
		}
		
	}
	
	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountNumber) {
		this.accountnumber = accountNumber;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerID) {
		this.customerid = customerID;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getLastchangetime() {
		return lastchangetime;
	}

	public void setLastchangetime(String lastChangeTime) {
		this.lastchangetime = lastChangeTime;
	}


}
