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
        return expenseService.calculateTotal();
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

    @GetMapping("/form")
    public String form() {
        return """
            <html>
            <body>
                <h1>Kakeibo</h1>
                <form action="/add" method="get">
                    Amount: <input type="number" name="amount" />
                    <button type="submit">Add</button>
                </form>
            </body>
            </html>
            """;
    }

    
}
