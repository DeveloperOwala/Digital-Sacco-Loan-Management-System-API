package com.lms.loans.repository;

import com.lms.loans.model.LoanCalculator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanCalculatorRepository extends JpaRepository<LoanCalculator,Long> {
}
