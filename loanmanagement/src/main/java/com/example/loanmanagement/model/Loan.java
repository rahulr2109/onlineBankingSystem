package com.example.loanmanagement.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Loan")
public class Loan {
    @Id
    private String id;
    private String name;
    private String email;
    private String course;
}
