package com.example.kakeibo.controller;

import com.example.kakeibo.model.Expense;
import com.example.kakeibo.service.ExpenseService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseApiController {

    private final ExpenseService expenseService;

    public ExpenseApiController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/total")
    public int getTotalExpense() {
        return expenseService.calculateTotal();
    }

    @GetMapping
    public List<Expense> getAll() {
        return expenseService.getAll();
    }

}
