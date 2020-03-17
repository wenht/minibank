package com.ibm.wenht.minibank.CustomerService.entiry;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
@Entity
public class Account {
	  @Id
	  private String accountnumber; 
	  @Column
	  private String customerid;  
	  @Column
	  private BigDecimal balance; 
	  @Column
	  private java.util.Date lastchangetime;
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public java.util.Date getLastchangetime() {
		return lastchangetime;
	}
	public void setLastchangetime(java.util.Date lastchangetime) {
		this.lastchangetime = lastchangetime;
	} 
}
