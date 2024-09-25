package com.lms.loans.repository;

import com.lms.loans.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> {
    void deleteLoanById(Long id);

    Loan getLoanById(Long id);
}
