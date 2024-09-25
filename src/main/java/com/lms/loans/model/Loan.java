package com.lms.loans.model;

import java.util.Date;

public class Loan {
    public String loan_ID;
    public String BorrowerName;
    public float loanAmount;
    public int loanTerm;
    public String loanStatus;
    public Date dueDate;

    public Loan(String loan_ID, String borrowerName, float loanAmount, int loanTerm, String loanStatus, Date dueDate) {
        this.loan_ID = loan_ID;
        BorrowerName = borrowerName;
        this.loanAmount = loanAmount;
        this.loanTerm = loanTerm;
        this.loanStatus = loanStatus;
        this.dueDate = dueDate;
    }
    public String getLoan_ID() {
        return loan_ID;
    }

    public void setLoan_ID(String loan_ID) {
        this.loan_ID = loan_ID;
    }

    public String getBorrowerName() {
        return BorrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        BorrowerName = borrowerName;
    }

    public float getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(float loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }


}
