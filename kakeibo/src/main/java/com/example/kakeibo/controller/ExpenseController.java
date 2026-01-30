package com.example.kakeibo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.kakeibo.entity.Expense;
import com.example.kakeibo.service.ExpenseService;

@RestController
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // 全件取得
    @GetMapping("/expenses")
    public List<Expense> list() {
        return expenseService.findAll();
    }

    // ID指定取得
    @GetMapping("/expenses/{id}")
    public Expense getById(@PathVariable Long id) {
        return expenseService.findById(id);
    }
}
