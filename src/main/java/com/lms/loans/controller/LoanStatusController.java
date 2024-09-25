package com.lms.loans.controller;

import com.lms.loans.model.Loan;
import com.lms.loans.model.LoanStatus;
import com.lms.loans.service.LoanService;
import com.lms.loans.service.LoanStatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class LoanStatusController {
    private final LoanStatusService loanStatusService;

    public LoanStatusController(LoanStatusService loanStatusService) {
        this.loanStatusService = loanStatusService;
    }
    @PutMapping("/updateLoanStatus")
    public ResponseEntity<LoanStatus> updateCustomer(@RequestBody LoanStatus loanStatus) {
        LoanStatus updateLoanStatus = loanStatusService.updateLoanStatus(loanStatus);
        return new ResponseEntity<>(updateLoanStatus, HttpStatus.OK);
    }


}
