package com.lms.loans.controller;

import com.lms.loans.model.Loan;
import com.lms.loans.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/all")
    //get  loan
    public ResponseEntity<List<Loan>> getAllLoans() {
        List<Loan> loan = loanService.findAllLoan();

        return new ResponseEntity<>(loan, HttpStatus.OK);
    }

    // get loan by id rest API
    @GetMapping("/{id}")
    public ResponseEntity<Loan> getCustomerById(@PathVariable("id") Long id) {
        Loan loan = loanService.getLoanById(id);

        return new ResponseEntity<>(loan, HttpStatus.OK);
    }

    //add loan
    @PostMapping("/add")
    public ResponseEntity<Loan> addCustomer(@RequestBody Loan loan) {
        Loan newLoan = loanService.addLoan(loan);
        return new ResponseEntity<>(newLoan, HttpStatus.CREATED);
    }

    //update loan
    @PutMapping("/update")
    public ResponseEntity<Loan> updateCustomer(@RequestBody Loan loan) {
        Loan updateLoan = loanService.updateLoan(loan);
        return new ResponseEntity<>(updateLoan, HttpStatus.OK);
    }

    //delete loan by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLoanById(@PathVariable("id") Long id) {
        loanService.deleteLoan(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

