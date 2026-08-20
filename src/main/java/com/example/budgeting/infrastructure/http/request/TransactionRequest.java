package com.example.budgeting.infrastructure.http.request;

import com.example.budgeting.application.Input.PersistTransactionInput;
import com.example.budgeting.domain.Category;

public record TransactionRequest(String description, long amount, Category category) {

    public PersistTransactionInput toInput() {
        return new PersistTransactionInput(description, amount, category);
    }
}
