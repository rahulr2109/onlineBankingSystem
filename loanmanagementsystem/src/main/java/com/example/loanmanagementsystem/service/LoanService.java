package com.example.loanmanagementsystem.service;

import com.example.loanmanagementsystem.model.Loan;
import com.example.loanmanagementsystem.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Optional<Loan> getLoanById(String id) {
        return loanRepository.findById(id);
    }

    public Loan createLoan(Loan loan) {
        loan.setStatus("pending");
        return loanRepository.save(loan);
    }

    public Loan updateLoan(String id, Loan loan) {
        Optional<Loan> existingLoan = loanRepository.findById(id);
        if (existingLoan.isPresent()) {
            Loan updatedLoan = existingLoan.get();
            updatedLoan.setLoanType(loan.getLoanType());
            updatedLoan.setAmount(loan.getAmount());
            updatedLoan.setReason(loan.getReason());
            updatedLoan.setStatus(loan.getStatus());
            return loanRepository.save(updatedLoan);
        }
        return null;
    }

    public void deleteLoan(String id) {
        loanRepository.deleteById(id);
    }

    // public Loan updateLoanStatus(String id, Loan changeLoanStatus) {
    //     Optional<Loan> existingLoan = loanRepository.findById(id);
    //     if (existingLoan.isPresent()) {
    //         Loan updatedLoan = existingLoan.get();
    //         updatedLoan.setStatus(changeLoanStatus.getStatus());
    //         return loanRepository.save(updatedLoan);
    //     }
    //     return null;
    // }
}
