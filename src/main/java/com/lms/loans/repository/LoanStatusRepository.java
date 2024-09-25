package com.lms.loans.repository;

import com.lms.loans.model.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanStatusRepository extends JpaRepository<LoanStatus,Long> {
}
