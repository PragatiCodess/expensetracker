package com.pragati.expensetracker.service;

import com.pragati.expensetracker.entity.Expense;
import com.pragati.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository repository;

    public Expense saveExpense(Expense expense) {
        return repository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return repository.findAll();
    }

    public Expense updateExpense(Long id, Expense updatedExpense) {


        Expense expense = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        expense.setTitle(updatedExpense.getTitle());
        expense.setAmount(updatedExpense.getAmount());

        return repository.save(expense);
    }

public void deleteExpense(Long id) {

repository.deleteById(id);

}


}