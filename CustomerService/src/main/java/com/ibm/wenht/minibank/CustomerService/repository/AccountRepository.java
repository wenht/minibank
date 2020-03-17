package com.ibm.wenht.minibank.CustomerService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.wenht.minibank.CustomerService.entiry.*;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
	List<Account> findByCustomerid(String customerid);
}

