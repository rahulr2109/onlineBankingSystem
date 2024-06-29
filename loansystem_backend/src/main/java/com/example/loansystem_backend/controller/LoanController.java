package com.example.loansystem_backend.controller;

import com.example.loansystem_backend.model.Loan;
import com.example.loansystem_backend.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/requestloan")
    public ResponseEntity<Loan> requestLoan(@RequestBody Loan loan) {
        Loan newLoan = loanService.requestLoan(loan);
        System.out.println(newLoan.getId());
        return ResponseEntity.ok(newLoan);
    }

    @GetMapping("/loan/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable String id) {
        return loanService.getLoanById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<Loan>> getLoansByUsername(@PathVariable String username) {
        List<Loan> loans = loanService.getLoansByUsername(username);
        return ResponseEntity.ok(loans);
    }

    @PutMapping("/{id}/status/{status}")
    public ResponseEntity<Loan> changeLoanStatus(@PathVariable String id, @PathVariable String status) {
        Loan updatedLoan = loanService.changeLoanStatus(id, status);
        return ResponseEntity.ok(updatedLoan);
    }
}
