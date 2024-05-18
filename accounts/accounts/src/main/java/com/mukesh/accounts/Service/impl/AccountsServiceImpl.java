package com.mukesh.accounts.Service.impl;

import com.mukesh.accounts.Dto.CustomerDto;
import com.mukesh.accounts.Service.IAccountsService;
import com.mukesh.accounts.repository.AccountRepository;
import com.mukesh.accounts.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;


    /**
     *
     * @param customerDto
     */

    @Override
    public void createAccount(CustomerDto customerDto) {

    }
}
