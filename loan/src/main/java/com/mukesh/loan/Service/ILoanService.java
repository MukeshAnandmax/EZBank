package com.mukesh.loan.Service;

import com.mukesh.loan.dto.LoansDto;

public interface ILoanService {



    void createLoan(String mobileNumber);

    LoansDto fetchLoan(String mobileNumber);

    boolean updateLoan(LoansDto loansDto);

    boolean deleteLoan(String mobileNumber);

}
