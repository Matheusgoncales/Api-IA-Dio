package com.example.budgeting.application;


import com.example.budgeting.application.Input.PersistTransactionInput;
import com.example.budgeting.application.Output.TransactionOutPut;
import com.example.budgeting.domain.Transaction;
import com.example.budgeting.domain.TransactionRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class PersistTransactionUseCase {
    private final TransactionRepository transactionRepository;

    public PersistTransactionUseCase (TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    @Tool(name = "persist-transaction", description = "persiste uma nova transação financeira")
    public TransactionOutPut execute(PersistTransactionInput input){
        var transaction = transactionRepository.save(
                new Transaction(input.description(), input.amount(), input.category()));

        return TransactionOutPut.from(transaction);
    }
}
