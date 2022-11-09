package org.exalt.dto;

import lombok.Data;
import org.exalt.model.impl.OperationType;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class OperationResponse {
    private final BigDecimal amount;
    private final OperationType typeOperation;
    private final Instant createAt;
    private final BigDecimal balance;

    public OperationResponse(BigDecimal amount, OperationType operationType, BigDecimal balance, Instant createdAt) {
        this.amount = amount;
        this.typeOperation = operationType;
        this.balance = balance;
        this.createAt = createdAt;
    }
}
