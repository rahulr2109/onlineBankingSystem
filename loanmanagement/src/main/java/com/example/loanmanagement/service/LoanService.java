package com.example.loanmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loanmanagement.model.Loan;
import com.example.loanmanagement.repository.LoanRepository;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public Loan addLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Loan updateLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public void deleteLoan(String id) {
        loanRepository.deleteById(id);
    }
}
