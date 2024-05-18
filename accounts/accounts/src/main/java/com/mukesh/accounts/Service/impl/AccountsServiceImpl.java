package com.mukesh.accounts.Service.impl;

import com.mukesh.accounts.Constants.AccountsConstants;
import com.mukesh.accounts.Dto.CustomerDto;
import com.mukesh.accounts.Exception.CustomerAlreadyExistException;
import com.mukesh.accounts.Mapper.CustomerMapper;
import com.mukesh.accounts.Service.IAccountsService;
import com.mukesh.accounts.entity.Accounts;
import com.mukesh.accounts.entity.Customer;
import com.mukesh.accounts.repository.AccountRepository;
import com.mukesh.accounts.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;


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

        Optional<Customer> byMobileNumer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(byMobileNumer.isPresent()){
            throw new CustomerAlreadyExistException("Customer Already registered with the given Mobile Number "+customerDto.getMobileNumber());
        }

        Customer customer = CustomerMapper.mapToCustomer(customerDto,new Customer());

        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Mukesh");

        Customer savedCustomer = customerRepository.save(customer);
        Accounts newAccount = createNewAccount(savedCustomer);
        accountRepository.save(newAccount);

    }

    private Accounts createNewAccount(Customer customer){

        Accounts accounts =new Accounts();
        accounts.setCustomerId( customer.getCustomerId());
        long randomAccountNumber= (long)1e9 + new Random().nextInt(900000000);
        accounts.setAccountNumber(randomAccountNumber);
        accounts.setAccountType(AccountsConstants.SAVINGS);
        accounts.setBranchAddress(AccountsConstants.ADDRESS);
        accounts.setCreatedAt(LocalDateTime.now());
        accounts.setCreatedBy("Mukesh Anand");

        return accounts;
    }
}
