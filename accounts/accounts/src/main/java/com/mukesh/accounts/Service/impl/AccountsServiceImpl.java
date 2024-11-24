package com.mukesh.accounts.Service.impl;

import com.mukesh.accounts.Constants.AccountsConstants;
import com.mukesh.accounts.dto.AccountsDto;
import com.mukesh.accounts.dto.CustomerDto;
import com.mukesh.accounts.Exception.CustomerAlreadyExistException;
import com.mukesh.accounts.Exception.ResourceNotFoundException;
import com.mukesh.accounts.Mapper.AccountsMapper;
import com.mukesh.accounts.Mapper.CustomerMapper;
import com.mukesh.accounts.Service.IAccountsService;
import com.mukesh.accounts.entity.Accounts;
import com.mukesh.accounts.entity.Customer;
import com.mukesh.accounts.repository.AccountRepository;
import com.mukesh.accounts.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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


        return accounts;
    }



    @Override
    public CustomerDto fetchAccount(String mobileNumber) {

        System.out.println("inside service 1");

        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer","mobileNumber", mobileNumber)
        );

        System.out.println("inside service 2");


        Accounts accounts = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                ()-> new ResourceNotFoundException("Account","customerId",customer.getCustomerId().toString()));

        System.out.println("inside service 3");


        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));


        return customerDto;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdated=false;
        AccountsDto accountsDto =  customerDto.getAccountsDto();
        if(accountsDto!=null){
            Accounts accounts = accountRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
                    ()-> new ResourceNotFoundException("Account","AccountNumber",accountsDto.getAccountNumber().toString()));

            AccountsMapper.mapToAccounts(accountsDto,accounts);
            accounts= accountRepository.save(accounts);


            Long customerId = accounts.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer", "customerId", customerId.toString())
            );

            CustomerMapper.mapToCustomer(customerDto,customer);
            customerRepository.save(customer);
            isUpdated=true;

        }

        return  isUpdated;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {

        boolean isDeleted= false;

        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer","mobileNumber", mobileNumber)
        );

        accountRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        isDeleted = true;

        return  isDeleted;
    }


}
