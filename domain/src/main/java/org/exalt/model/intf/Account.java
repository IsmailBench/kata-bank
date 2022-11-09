package org.exalt.model.intf;

import org.exalt.exceptions.AmountGreaterThanBalanceInOperationException;
import org.exalt.exceptions.NegativeAmountInOperationException;

import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

public interface Account {
    UUID getId();
    BigDecimal getBalance();
    String getName();
    Set<Operation> getOperationHistory();
    void addOperation(Operation operation);
    void checkAmount(BigDecimal amount) throws NegativeAmountInOperationException;
    void checkBalance(BigDecimal amount) throws AmountGreaterThanBalanceInOperationException;
    void deposit(BigDecimal amount) throws NegativeAmountInOperationException;
    void withdraw(BigDecimal amount) throws NegativeAmountInOperationException, AmountGreaterThanBalanceInOperationException;
}
