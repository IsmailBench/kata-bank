package org.exalt.model.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.exalt.exceptions.AmountGreaterThanBalanceInTransactionException;
import org.exalt.exceptions.NegativeAmountInTransactionException;
import org.exalt.model.intf.Account;
import org.exalt.model.intf.Transaction;

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
    private Set<Transaction> transaction;


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
    public Set<Transaction> getTransactionHistory() {
        return transaction;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        this.transaction.add(transaction);
    }

    /**
     * function to check if amount is positive
     * @param amount in transaction
     * @throws NegativeAmountInTransactionException if amount is negative throw exception
     */
    @Override
    public void checkAmount(BigDecimal amount) throws NegativeAmountInTransactionException {
        if ( amount.compareTo(BigDecimal.ZERO) < 1){
            throw new NegativeAmountInTransactionException();
        }
    }

    /**
     * function to check balance before withdraw
     * @param amount in transaction
     * @throws AmountGreaterThanBalanceInTransactionException if amount is greater than balance throw exception
     */
    @Override
    public void checkBalance(BigDecimal amount) throws AmountGreaterThanBalanceInTransactionException {
        if(amount.compareTo(balance) > 0 ){
            throw new AmountGreaterThanBalanceInTransactionException();
        }
    }
    /**
     * function represent deposit operation
     * @param amount in deposit transaction
     */
    @Override
    public void deposit(BigDecimal amount) throws NegativeAmountInTransactionException {
        checkAmount(amount);
        balance = balance.add(amount);
    }

    /**
     * function represent withdraw operation
     * @param amount in withdraw transaction
     */
    @Override
    public void withdraw(BigDecimal amount) throws NegativeAmountInTransactionException, AmountGreaterThanBalanceInTransactionException{
        checkAmount(amount);
        checkBalance(amount);
        if(amount.compareTo(balance) == -1 ){
            balance = balance.subtract(amount);
        }
    }

}
