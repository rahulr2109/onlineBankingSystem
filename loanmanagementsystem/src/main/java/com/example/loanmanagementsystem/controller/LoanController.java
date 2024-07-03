package com.example.loanmanagementsystem.controller;

import com.example.loanmanagementsystem.model.Loan;
import com.example.loanmanagementsystem.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/loans")
@CrossOrigin(origins = "*")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }

    @GetMapping("/{id}")
    public Optional<Loan> getLoanById(@PathVariable String id) {
        return loanService.getLoanById(id);
    }

    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {
        return loanService.createLoan(loan);
    }

    @PutMapping("/{id}")
    public Loan updateLoan(@PathVariable String id, @RequestBody Loan loan) {
        return loanService.updateLoan(id, loan);
    }

    @DeleteMapping("/{id}")
    public void deleteLoan(@PathVariable String id) {
        loanService.deleteLoan(id);
    }

    @PutMapping("/status/{id}")
    public Loan updateLoanStatus(@PathVariable String id, @RequestBody String status) {
        return loanService.updateLoanStatus(id, status);
    }
}
