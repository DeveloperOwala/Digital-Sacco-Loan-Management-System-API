package com.lms.loans.service;

import com.lms.loans.model.Loan;
import com.lms.loans.repository.LoanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LoanService {
    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Loan addLoan(Loan loan){

        return loanRepository.save(loan);
    }

    public List<Loan> findAllLoan(){
        return loanRepository.findAll();
    }
    public Loan updateLoan(Loan loan){
        return loanRepository.save(loan);

    }
    public Loan getLoanById(Long id){
        return loanRepository.getLoanById(id);

    }
    public  void deleteLoan(Long id){
        loanRepository.deleteLoanById(id);
    }
}
