package com.lms.loans.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class LoanCalculator {
    @DateTimeFormat(pattern = "MM/dd/yyyy") private Date paymentDate;
    private double balance;
    private double principalPaid;
    private double interestPaid;
    private double accumulatedInterest;

    public LoanCalculator(int paymentNumber, Date paymentDate, double balance, double principalPaid, double interestPaid, double accumulatedInterest) {
        this.paymentNumber = paymentNumber;
        this.paymentDate = paymentDate;
        this.balance = balance;
        this.principalPaid = principalPaid;
        this.interestPaid = interestPaid;
        this.accumulatedInterest = accumulatedInterest;
    }

    private int paymentNumber;

    public int getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(int paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getPrincipalPaid() {
        return principalPaid;
    }

    public void setPrincipalPaid(double principalPaid) {
        this.principalPaid = principalPaid;
    }

    public double getInterestPaid() {
        return interestPaid;
    }

    public void setInterestPaid(double interestPaid) {
        this.interestPaid = interestPaid;
    }

    public double getAccumulatedInterest() {
        return accumulatedInterest;
    }

    public void setAccumulatedInterest(double accumulatedInterest) {
        this.accumulatedInterest = accumulatedInterest;
    }



}
