package com.ecom.customerorder.repository;

import com.ecom.customerorder.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> { }
//provide function to interact with db
//provide sql functions inbuilt using java like findall, getbyid,delete,etc