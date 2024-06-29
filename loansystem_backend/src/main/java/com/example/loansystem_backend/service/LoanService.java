package com.example.loansystem_backend.service;

import com.example.loansystem_backend.model.Loan;
import com.example.loansystem_backend.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public Loan requestLoan(Loan loan){
        return loanRepository.save(loan);
    }

    public Loan updateLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public void deleteLoan(String id) {
        loanRepository.deleteById(id);
    }

    public Optional<Loan> getLoanById(String id) {
        return loanRepository.findById(id);
    }

    public List<Loan> getLoansByUsername(String Username) {
        return loanRepository.findByUsername(Username);
    }

    public Loan changeLoanStatus(String Id, String status) {
        Optional<Loan> optionalLoan = loanRepository.findById(Id);
        if (optionalLoan.isPresent()) {
            Loan loan = optionalLoan.get();
            loan.setStatus(status);
            return loanRepository.save(loan);
        } else {
            throw new RuntimeException("Loan not found");
        }
    }
}
