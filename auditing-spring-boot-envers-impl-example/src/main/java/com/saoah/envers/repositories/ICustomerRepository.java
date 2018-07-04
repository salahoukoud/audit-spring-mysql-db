package com.saoah.envers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.saoah.envers.model.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {
}
