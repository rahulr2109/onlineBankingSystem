package com.example.loansystem_backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "loans")
public class Loan {
    @Id
    private String id;
    private String username;
    private double amount;
    private String status;
    private String createdAt;

    private String loanType;
    private String reason;

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Loan(String username, double amount, String loanType, String reason) {
        this.username = username;
        this.amount = amount;
        this.status = "Pending";
        Date date = new java.util.Date();
        this.createdAt = date.toString();
        this.loanType = loanType;
        this.reason = reason;
    }
}
