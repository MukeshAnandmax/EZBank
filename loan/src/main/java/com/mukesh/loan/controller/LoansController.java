package com.mukesh.loan.controller;

import com.mukesh.loan.Service.ILoanService;
import com.mukesh.loan.constants.LoansConstants;
import com.mukesh.loan.dto.LoansDto;
import com.mukesh.loan.dto.ResponseDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api")
@Validated
public class LoansController {

    private ILoanService loanService;


    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoan(@RequestParam @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile Number must be 10 digits")
            String mobileNumber) {

        loanService.createLoan(mobileNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(LoansConstants.STATUS_201, LoansConstants.MESSAGE_201));

    }


    @GetMapping("/fetch")
    public ResponseEntity<LoansDto> fetchLoanDetails(@RequestParam @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile Number must be 10 digits")
            String mobileNumber){
        LoansDto loansDto = loanService.fetchLoan(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(loansDto);
    }



    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateLoanDetails(@Valid  @RequestBody LoansDto loansDto){

        boolean isUpdated = loanService.updateLoan(loansDto);
        if(isUpdated){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
        }else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(LoansConstants.STATUS_417, LoansConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteLoanDetails(@RequestParam @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile Number must be 10 digits")
            String mobileNumber){
        boolean isDeleted = loanService.deleteLoan(mobileNumber);
        if(isDeleted){
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
        }else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDto(LoansConstants.STATUS_417, LoansConstants.MESSAGE_417_DELETE));
        }
    }


}
