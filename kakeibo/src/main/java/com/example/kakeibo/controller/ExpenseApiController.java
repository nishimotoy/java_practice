package com.example.kakeibo.controller;

import com.example.kakeibo.model.Expense;
import com.example.kakeibo.service.ExpenseService;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/search")
    public List<Expense> search(
            @RequestParam(required = false) String category) {

        return expenseService.search(category);
    }

    @PostMapping
    public List<Expense> addExpense(@RequestBody Expense expense) {
        expenseService.addExpense(expense);
        return expenseService.getAll();
    }

    /* 
    @PostMapping("/api/expenses")
    public void create(@RequestBody String body) {
        System.out.println("==== RAW BODY ====");
        System.out.println(body);
    }
    */

    @GetMapping("/{id}")
    public Expense getById(@PathVariable int id) {
        return expenseService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable int id) {
        expenseService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Expense updateExpense(
            @PathVariable int id,
            @RequestBody Expense expense) {

        return expenseService.update(id, expense);
    }

}
