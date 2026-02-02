package com.example.kakeibo.controller;

import com.example.kakeibo.entity.Expense;
import com.example.kakeibo.service.ExpenseService;

import jakarta.validation.Valid;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExpenseViewController {

    private final ExpenseService expenseService;

    public ExpenseViewController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/expenses")
    public String list(Model model) {
        model.addAttribute("expenses", expenseService.findAll());
        model.addAttribute("expense", new Expense());   // 追加用
        model.addAttribute("mode", "add");               // ★追加モード
        return "expenses";
    }

    @PostMapping("/expenses")
    public String add(
            @Valid @ModelAttribute Expense expense,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("expenses", expenseService.findAll());
            model.addAttribute("mode", "add"); // ★これが重要
            return "expenses";
        }
        expenseService.save(expense);
        return "redirect:/expenses";
    }

    @GetMapping("/expenses/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Expense expense = expenseService.findById(id);
        model.addAttribute("expense", expense);
        model.addAttribute("mode", "edit");              // ★編集モード
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
            @Valid @ModelAttribute Expense expense,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("mode", "edit"); // ★
            return "expense-edit";
        }

        expenseService.update(id, expense);
        return "redirect:/expenses";
    }

}
