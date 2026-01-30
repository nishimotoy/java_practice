package com.example.kakeibo.service;

import com.example.kakeibo.entity.Expense;
import com.example.kakeibo.exception.ExpenseNotFoundException;
import com.example.kakeibo.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // 全件取得
    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    // ID指定取得
    public Expense findById(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() -> new ExpenseNotFoundException(id));
    }

    // 新規追加
    public Expense save(Expense expense) {
        return expenseRepository.save(expense);
    }

    // 更新
    public Expense update(Long id, Expense updatedExpense) {
        Expense expense = findById(id);
        expense.setDate(updatedExpense.getDate());
        expense.setCategory(updatedExpense.getCategory());
        expense.setAmount(updatedExpense.getAmount());
        expense.setMemo(updatedExpense.getMemo());
        return expenseRepository.save(expense);
    }

    // 削除
    public void delete(Long id) {
        expenseRepository.deleteById(id);
    }
}
