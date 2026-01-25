package com.example.kakeibo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.kakeibo.model.Expense;
import com.example.kakeibo.service.ExpenseService;

@RestController
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/total")
    public int total() {
        return expenseService.getTotal();
    }

    @GetMapping("/list")
    public List<Expense> list() {
        return expenseService.getAll();
    }

    @GetMapping("/add")
    public String add(@RequestParam int amount) {
        Expense expense = new Expense(amount);
        expenseService.addExpense(expense);
        return "added: " + amount;
    }
    
}
