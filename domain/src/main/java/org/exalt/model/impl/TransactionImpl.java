package org.exalt.model.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.exalt.model.intf.Transaction;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionImpl implements Transaction {

    private UUID transactionId;
    private BigDecimal amount;
    private TransactionType typeTransaction;
    private Instant createAt;
    private BigDecimal balance;

    @Override
    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public Instant getCreatedAt() {
        return createAt;
    }

    @Override
    public TransactionType getTransactionType() {
        return typeTransaction;
    }
}
