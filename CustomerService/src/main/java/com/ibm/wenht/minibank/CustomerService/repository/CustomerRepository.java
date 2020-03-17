package com.ibm.wenht.minibank.CustomerService.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.wenht.minibank.CustomerService.entiry.*;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
}