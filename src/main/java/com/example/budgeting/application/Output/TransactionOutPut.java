package com.example.budgeting.application.Output;

import com.example.budgeting.domain.Category;
import com.example.budgeting.domain.Transaction;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record TransactionOutPut(String id, String description, String category, double value) {
    public static TransactionOutPut from(Transaction transaction) {
        return new TransactionOutPut(
                transaction.getId().uuid().toString(),
                transaction.getDescription(),
                transaction.getCategory().name(),
                BigDecimal.valueOf(transaction.getAmount()).setScale(2, RoundingMode.HALF_UP).doubleValue());
    }
}
