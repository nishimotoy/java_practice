package com.example.kakeibo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.kakeibo.model.Expense;

@Service
public class ExpenseService {

    private final List<Expense> expenses = new ArrayList<>();

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public int calculateTotal() {
        int total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        return total;
    }

    public List<Expense> getAll() {
        return expenses;
    }
}


