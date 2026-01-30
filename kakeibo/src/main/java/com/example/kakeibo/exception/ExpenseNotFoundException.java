package com.example.kakeibo.exception;

public class ExpenseNotFoundException extends RuntimeException {

    public ExpenseNotFoundException(Long id) {
        super("Expense not found: id=" + id);
    }
}
