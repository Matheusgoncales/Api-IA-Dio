package com.example.budgeting.application.Input;

import com.example.budgeting.domain.Category;
import org.springframework.ai.tool.annotation.ToolParam;

public record PersistTransactionInput(@ToolParam(description = "Descrição do gasto")
        String description, long amount, Category category) {

}
