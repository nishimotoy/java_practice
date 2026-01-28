package com.example.kakeibo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.kakeibo.model.Expense;

@Service
public class ExpenseService {

    private final List<Expense> expenses = new ArrayList<>();

    public ExpenseService() {
        expenses.add(new Expense("FOOD", 1200));
        expenses.add(new Expense("TRANSPORT", 800));
    }
    
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

    public List<Expense> search(String category) {
        if (category == null) {
            return expenses;
        }

        return expenses.stream()
                .filter(e -> category.equals(e.getCategory()))
                .toList();
    }

}


