package com.mukesh.accounts.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerAlreadyExistException extends  RuntimeException{

    public CustomerAlreadyExistException(String msg){
        super(msg);

    }
}
