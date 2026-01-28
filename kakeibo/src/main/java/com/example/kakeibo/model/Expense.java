package com.example.kakeibo.model;

public class Expense {

    private int amount;

    public Expense(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
