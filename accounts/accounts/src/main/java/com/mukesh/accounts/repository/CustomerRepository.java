package com.mukesh.accounts.repository;

import com.mukesh.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

  public Optional<Customer> findByMobileNumber(String mobileNumber);

}
