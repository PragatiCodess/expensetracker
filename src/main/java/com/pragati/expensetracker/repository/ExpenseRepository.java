package com.pragati.expensetracker.repository;

import com.pragati.expensetracker.entity.Expense;
import com.pragati.expensetracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByUser(User user);
}