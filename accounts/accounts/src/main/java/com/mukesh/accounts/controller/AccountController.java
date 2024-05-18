package com.mukesh.accounts.controller;

import com.mukesh.accounts.Constants.AccountsConstants;
import com.mukesh.accounts.Dto.CustomerDto;
import com.mukesh.accounts.Dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountController {


    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto){



        return ResponseEntity.status(HttpStatus.CREATED)
                .body( new ResponseDto(AccountsConstants.STATUS_201,AccountsConstants.MESSAGE_201));
    }


}
