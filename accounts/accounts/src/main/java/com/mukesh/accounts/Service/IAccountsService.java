package com.mukesh.accounts.Service;

import com.mukesh.accounts.Dto.CustomerDto;

public interface IAccountsService {

    /**
     *
     * @param customerDto
     */
    void createAccount(CustomerDto customerDto);
}
