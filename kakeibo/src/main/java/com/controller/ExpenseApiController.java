package com.example.kakeibo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kakeibo.model.Expense;
import com.example.kakeibo.service.ExpenseService;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseApiController {

    private final ExpenseService expenseService;

    public ExpenseApiController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public List<Expense> list() {
        return expenseService.getAll();
    }

    @GetMapping("/total")
    public Map<String, Integer> total() {
        Map<String, Integer> result = new HashMap<>();
        result.put("total", expenseService.calculateTotal());
        return result;
    }
    
}
