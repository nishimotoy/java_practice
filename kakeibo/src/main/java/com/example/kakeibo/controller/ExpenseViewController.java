package com.example.kakeibo.controller;

import com.example.kakeibo.entity.Expense;
import com.example.kakeibo.service.ExpenseService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

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
        model.addAttribute("expense", new Expense());
        return "expenses";
    }

    @PostMapping("/expenses")
    public String add(
            @Valid Expense expense,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("expenses", expenseService.findAll());
            return "expenses";
        }
        expenseService.save(expense);
        return "redirect:/expenses";
    }

    @GetMapping("/expenses/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("expense", expenseService.findById(id));
        return "expense-edit";
    }

    @PostMapping("/expenses/{id}/delete")
    public String delete(@PathVariable Long id) {
        expenseService.delete(id);
        return "redirect:/expenses";
    }

    @PostMapping("/expenses/{id}")
    public String update(
            @PathVariable Long id,
            @Valid Expense expense,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "expense-edit";
        }
        expenseService.update(id, expense);
        return "redirect:/expenses";
    }

}
