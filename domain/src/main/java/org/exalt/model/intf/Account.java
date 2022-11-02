package org.exalt.model.intf;

import org.exalt.exceptions.AmountGreaterThanBalanceInTransactionException;
import org.exalt.exceptions.NegativeAmountInTransactionException;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public interface Account {
    UUID getId();
    BigDecimal getBalance();
    String getName();
    Set<Transaction> getTransactionHistory();
    void addTransaction(Transaction transaction);
    void checkAmount(BigDecimal amount) throws NegativeAmountInTransactionException;
    void checkBalance(BigDecimal amount) throws AmountGreaterThanBalanceInTransactionException;
    void deposit(BigDecimal amount) throws NegativeAmountInTransactionException;
    void withdraw(BigDecimal amount) throws NegativeAmountInTransactionException, AmountGreaterThanBalanceInTransactionException;
}
