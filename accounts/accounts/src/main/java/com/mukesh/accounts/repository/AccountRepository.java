package com.mukesh.accounts.repository;

import com.mukesh.accounts.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository  extends JpaRepository<Accounts ,Long> {

     Optional<Accounts> findByCustomerId(Long customerId);
}
