package com.mukesh.loan.Service.impl;

import com.mukesh.loan.Service.ILoanService;
import com.mukesh.loan.constants.LoansConstants;
import com.mukesh.loan.dto.LoansDto;
import com.mukesh.loan.entity.Loans;
import com.mukesh.loan.exception.LoanAlreadyExistException;
import com.mukesh.loan.exception.ResourceNotFoundException;
import com.mukesh.loan.mapper.LoansMapper;
import com.mukesh.loan.repository.LoansRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements ILoanService {

    LoansRepository loansRepository;

    @Override
    public void createLoan(String mobileNumber) {

        Optional<Loans> byMobileNumber = loansRepository.findByMobileNumber(mobileNumber);

        if(byMobileNumber.isPresent()) {
            throw new LoanAlreadyExistException("Loan already exist with mobile number "+mobileNumber);
        } else {
            Loans newLoan = createNewLoan(mobileNumber);
            loansRepository.save(newLoan);
        }
    }




    private Loans createNewLoan( String mobileNumber) {
        Loans loans = new Loans();
        loans.setMobileNumber(mobileNumber);
        long randomLoanNumber = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
        loans.setLoanNumber(String.valueOf(randomLoanNumber));
        loans.setLoanType(LoansConstants.HOME_LOAN);
        loans.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT);
        loans.setAmountPaid(0);
        loans.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT);
        return loans;
    }

    @Override
    public LoansDto fetchLoan(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber));
        return LoansMapper.mapToLoansDto(loans, new LoansDto());
    }

    @Override
    public boolean updateLoan(LoansDto loansDto) {
        Loans loans = loansRepository.findByLoanNumber(loansDto.getLoanNumber()).orElseThrow(() -> new ResourceNotFoundException("Loan", "loanNumber", loansDto.getLoanNumber()));
        Loans updatedLoan = LoansMapper.mapToLoans(loansDto, loans);
        loansRepository.save(updatedLoan);
        return true;
    }

    @Override
    public boolean deleteLoan(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber));
        loansRepository.deleteById(loans.getLoanId());
        return true;

    }
}
