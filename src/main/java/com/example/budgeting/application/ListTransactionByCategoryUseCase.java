package com.example.budgeting.application;


import com.example.budgeting.application.Output.TransactionOutPut;
import com.example.budgeting.domain.Category;
import com.example.budgeting.domain.Transaction;
import com.example.budgeting.domain.TransactionRepository;
import com.example.budgeting.infrastructure.http.response.TransactionResponse;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListTransactionByCategoryUseCase {
    private final TransactionRepository transactionRepository;

    public ListTransactionByCategoryUseCase(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    @Tool(name = "list-transaction-by-category", description = "Lista transações financeiras por categoria")
    public List<TransactionOutPut> execute(@ToolParam(description = "Categoria de uma transação")
            Category category){
        return transactionRepository.findAllByCategory(category)
                .stream()
                .map(TransactionOutPut::from).toList();
    }

}
