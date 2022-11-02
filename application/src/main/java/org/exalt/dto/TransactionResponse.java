package org.exalt.dto;

import lombok.Data;
import org.exalt.model.impl.TransactionType;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class TransactionResponse {
    private final BigDecimal amount;
    private final TransactionType typeTransaction;
    private final Instant createAt;
    private final BigDecimal balance;

    public TransactionResponse(BigDecimal amount, TransactionType transactionType, BigDecimal balance, Instant createdAt) {
        this.amount = amount;
        this.typeTransaction = transactionType;
        this.balance = balance;
        this.createAt = createdAt;
    }
}
