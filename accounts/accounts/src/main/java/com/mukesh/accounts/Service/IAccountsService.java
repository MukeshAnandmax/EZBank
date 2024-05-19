package com.mukesh.accounts.Service;

import com.mukesh.accounts.Dto.CustomerDto;

public interface IAccountsService {

    /**
     *
     * @param customerDto
     */
    void createAccount(CustomerDto customerDto);
    CustomerDto fetchAccount(String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);
    boolean deleteAccount(String mobileNumber);
}
