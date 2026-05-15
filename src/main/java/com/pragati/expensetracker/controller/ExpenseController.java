package com.pragati.expensetracker.controller;

import com.pragati.expensetracker.entity.Expense;
import com.pragati.expensetracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService service;

    @PostMapping
    public Expense addExpense(@Valid @RequestBody Expense expense) {
        return service.saveExpense(expense);
    }

    @GetMapping
    public List<Expense> getExpenses() {
        return service.getAllExpenses();
    }

    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id,
                                 @RequestBody Expense updatedExpense) {
        return service.updateExpense(id, updatedExpense);
    }

    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable Long id) {
        service.deleteExpense(id);
        return "Expense deleted successfully";
    }
}