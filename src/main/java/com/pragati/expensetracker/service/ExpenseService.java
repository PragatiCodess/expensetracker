package com.pragati.expensetracker.service;

import com.pragati.expensetracker.entity.Expense;
import com.pragati.expensetracker.entity.User;
import com.pragati.expensetracker.repository.ExpenseRepository;
import com.pragati.expensetracker.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository repository;

    @Autowired
    private UserRepository userRepository;

    // SAVE expense for logged-in user
    public Expense saveExpense(Expense expense) {

        User user = getLoggedInUser();

        expense.setUser(user);

        return repository.save(expense);
    }

    // GET only logged-in user's expenses
    public List<Expense> getAllExpenses() {

        User user = getLoggedInUser();

        return repository.findByUser(user);
    }

    // UPDATE expense
    public Expense updateExpense(Long id, Expense updatedExpense) {

        Expense expense = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));

        expense.setTitle(updatedExpense.getTitle());
        expense.setAmount(updatedExpense.getAmount());
        expense.setCategory(updatedExpense.getCategory());

        return repository.save(expense);
    }

    // DELETE expense
    public void deleteExpense(Long id) {

        repository.deleteById(id);
    }

    // GET currently logged-in user
    private User getLoggedInUser() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String username = authentication.getName();

        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}