package com.example.loanmanagementsystem.repository;

import com.example.loanmanagementsystem.model.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoanRepository extends MongoRepository<Loan, String> {
}
