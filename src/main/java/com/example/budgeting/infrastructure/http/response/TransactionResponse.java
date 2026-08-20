package com.example.budgeting.infrastructure.http.response;

import com.example.budgeting.application.Output.TransactionOutPut;

import java.math.BigDecimal;

public record TransactionResponse(String id,String description, String category, Double amount) {
    public static TransactionResponse from(TransactionOutPut outPut) {
        return new TransactionResponse(outPut.id(), outPut.description(), outPut.category(), outPut.value() );
    }
}
