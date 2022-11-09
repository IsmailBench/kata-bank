package org.exalt.model.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.exalt.exceptions.AmountGreaterThanBalanceInOperationException;
import org.exalt.exceptions.NegativeAmountInOperationException;
import org.exalt.model.intf.Account;
import org.exalt.model.intf.Operation;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
public class AccountImpl implements Account {
    private UUID accountId;
    private String name;
    private BigDecimal balance;
    private Instant createAt;
    private Set<Operation> operation;


    @Override
    public UUID getId() {
        return accountId;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Set<Operation> getOperationHistory() {
        return operation;
    }

    @Override
    public void addOperation(Operation operation) {
        this.operation.add(operation);
    }

    /**
     * function to check if amount is positive
     * @param amount in operation
     * @throws NegativeAmountInOperationException if amount is negative throw exception
     */
    @Override
    public void checkAmount(BigDecimal amount) throws NegativeAmountInOperationException {
        if ( amount.compareTo(BigDecimal.ZERO) < 1){
            throw new NegativeAmountInOperationException();
        }
    }

    /**
     * function to check balance before withdraw
     * @param amount in operation
     * @throws AmountGreaterThanBalanceInOperationException if amount is greater than balance throw exception
     */
    @Override
    public void checkBalance(BigDecimal amount) throws AmountGreaterThanBalanceInOperationException {
        if(amount.compareTo(balance) > 0 ){
            throw new AmountGreaterThanBalanceInOperationException();
        }
    }
    /**
     * function represent deposit operation
     * @param amount in deposit operation
     */
    @Override
    public void deposit(BigDecimal amount) throws NegativeAmountInOperationException {
        checkAmount(amount);
        balance = balance.add(amount);
    }

    /**
     * function represent withdraw operation
     * @param amount in withdraw operation
     */
    @Override
    public void withdraw(BigDecimal amount) throws NegativeAmountInOperationException, AmountGreaterThanBalanceInOperationException{
        checkAmount(amount);
        checkBalance(amount);
        if(amount.compareTo(balance) == -1 ){
            balance = balance.subtract(amount);
        }
    }

}
