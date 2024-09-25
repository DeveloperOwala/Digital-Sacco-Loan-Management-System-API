package com.lms.loans.model;

public class LoanStatus {
    public String loan_ID;
    public String statusID;

    public LoanStatus(String loan_ID, String statusID) {
        this.loan_ID = loan_ID;
        this.statusID = statusID;
    }
    public String getLoan_ID() {
        return loan_ID;
    }

    public void setLoan_ID(String loan_ID) {
        this.loan_ID = loan_ID;
    }

    public String getStatusID() {
        return statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }
}

