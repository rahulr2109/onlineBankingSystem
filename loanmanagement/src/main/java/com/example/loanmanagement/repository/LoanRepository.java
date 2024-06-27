package com.example.loanmanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.loanmanagement.model.Loan;

@Repository
public interface LoanRepository extends MongoRepository<Loan, String> {
}
