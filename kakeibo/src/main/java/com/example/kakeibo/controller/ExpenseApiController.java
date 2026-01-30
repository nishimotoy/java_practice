package com.example.kakeibo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.kakeibo.entity.Expense;
import com.example.kakeibo.service.ExpenseService;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseApiController {

    private final ExpenseService expenseService;

    public ExpenseApiController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // 全件取得
    @GetMapping
    public List<Expense> getAll() {
        return expenseService.findAll();
    }

    // ID指定取得
    @GetMapping("/{id}")
    public Expense getById(@PathVariable Long id) {
        return expenseService.findById(id);
    }

    // 新規作成
    @PostMapping
    public Expense create(@RequestBody Expense expense) {
        return expenseService.save(expense);
    }

    // 更新
    @PutMapping("/{id}")
    public Expense update(
            @PathVariable Long id,
            @RequestBody Expense expense) {
        return expenseService.update(id, expense);
    }

    // 削除
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        expenseService.delete(id);
    }
}
