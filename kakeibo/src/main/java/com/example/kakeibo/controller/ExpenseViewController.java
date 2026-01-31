package com.example.kakeibo.controller;

import com.example.kakeibo.service.ExpenseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class ExpenseViewController {

    private final ExpenseService expenseService;

    public ExpenseViewController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses")
    public String list(Model model) {
        model.addAttribute("expenses", expenseService.findAll());
        return "expenses"; // templates/expenses.html
    }

    @PostMapping("/expenses")
    public String add(
            @RequestParam("date") LocalDate date,
            @RequestParam("category") String category,
            @RequestParam("amount") int amount,
            @RequestParam("memo") String memo
    ) {
        expenseService.add(date, category, amount, memo);
        return "redirect:/expenses";
    }
}
