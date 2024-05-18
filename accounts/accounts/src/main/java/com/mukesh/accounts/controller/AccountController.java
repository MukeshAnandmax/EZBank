package com.mukesh.accounts.controller;

import com.mukesh.accounts.Constants.AccountsConstants;
import com.mukesh.accounts.Dto.CustomerDto;
import com.mukesh.accounts.Dto.ResponseDto;
import com.mukesh.accounts.Service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountController {

    private IAccountsService accountsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto){

        accountsService.createAccount(customerDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body( new ResponseDto(AccountsConstants.STATUS_201,AccountsConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam String mobileNumber){

        CustomerDto customerDto = accountsService.fetchAccount(mobileNumber);
        System.out.println("inside Controller");

        return ResponseEntity.status(HttpStatus.OK)
                .body( customerDto);
    }


}
