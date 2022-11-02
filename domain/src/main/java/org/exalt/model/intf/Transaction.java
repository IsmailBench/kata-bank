package org.exalt.model.intf;


import org.exalt.model.impl.TransactionType;

import java.math.BigDecimal;
import java.time.Instant;

public interface Transaction {
    BigDecimal getAmount();
    BigDecimal getBalance();
    Instant getCreatedAt();
    TransactionType getTransactionType();

}
