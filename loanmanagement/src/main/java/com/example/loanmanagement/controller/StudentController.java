package com.example.loanmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.loanmanagement.model.Loan;
import com.example.loanmanagement.service.LoanService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {

    @Autowired
    private LoanService  loanService;

    @PostMapping
    public Loan addLoan(@RequestBody Loan student) {
        return  loanService.addLoan(student);
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return  loanService.getAllLoans();
    }

    @PutMapping
    public Loan updateLoan(@RequestBody Loan loan) {
        return  loanService.updateLoan(loan);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable String id) {
         loanService.deleteLoan(id);
    }
}
