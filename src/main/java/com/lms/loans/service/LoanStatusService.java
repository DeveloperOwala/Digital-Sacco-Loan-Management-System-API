package com.lms.loans.service;

import com.lms.loans.model.Loan;
import com.lms.loans.model.LoanStatus;
import com.lms.loans.repository.LoanRepository;
import com.lms.loans.repository.LoanStatusRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LoanStatusService {
    private final LoanStatusRepository loanStatusRepository;

    public LoanStatusService(LoanStatusRepository loanStatusRepository) {
        this.loanStatusRepository = loanStatusRepository;
    }

    public LoanStatus updateLoanStatus(LoanStatus loanStatus){
        return loanStatusRepository.save(loanStatus);

    }
}
