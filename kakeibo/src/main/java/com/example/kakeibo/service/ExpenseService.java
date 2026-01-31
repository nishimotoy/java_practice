package com.example.kakeibo.service;

import com.example.kakeibo.entity.Expense;
import com.example.kakeibo.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // 一覧取得
    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    // 追加
    public void add(LocalDate date, String category, int amount, String memo) {
        Expense expense = new Expense();
        expense.setDate(date);
        expense.setCategory(category);
        expense.setAmount(amount);
        expense.setMemo(memo);

        expenseRepository.save(expense);
    }

    // ID指定取得
    public Expense findById(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
    }
}
