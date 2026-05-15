package com.pragati.expensetracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Expense {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotBlank(message = "Title cannot be empty")
private String title;

@Positive(message = "Amount must be positive")
private double amount;

public Expense() {
}

public Long getId() {
    return id;
}

public String getTitle() {
    return title;
}

public double getAmount() {
    return amount;
}

public void setId(Long id) {
    this.id = id;
}

public void setTitle(String title) {
    this.title = title;
}

public void setAmount(double amount) {
    this.amount = amount;
}

}
