package com.example.loansystem_backend.repository;

import com.example.loansystem_backend.model.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Optional;

public interface LoanRepository extends MongoRepository<Loan, String> {
    List<Loan> findByUsername(String Username);

    List<Loan> findByStatus(String Status);
    Optional<Loan> findById(String Id);
}
