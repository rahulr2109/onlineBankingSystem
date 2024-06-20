package com.example.loansystem_backend.repository;

import com.example.loansystem_backend.model.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface LoanRepository extends MongoRepository<Loan, String> {
    List<Loan> findByCustomerId(String customerId);
}
