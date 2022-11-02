package org.exalt.model;


import org.exalt.exceptions.AmountGreaterThanBalanceInTransactionException;
import org.exalt.exceptions.NegativeAmountInTransactionException;
import org.exalt.model.impl.AccountImpl;
import org.exalt.model.intf.Account;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AccountImplTest {


    @Test
    public void should_not_withdraw_when_amount_is_greater_than_balance() {
        UUID id = UUID.randomUUID();
        Account account = new AccountImpl(id, "Paul", new BigDecimal(1000), Instant.now(), new HashSet<>());
        assertThrows(AmountGreaterThanBalanceInTransactionException.class , () -> account.withdraw(new BigDecimal(50000)));
    }

    @Test
    public void should_not_withdraw_when_amount_is_negative() {
        UUID id = UUID.randomUUID();
        Account account = new AccountImpl(id, "Paul", new BigDecimal(1000), Instant.now(), new HashSet<>());
        assertThrows(NegativeAmountInTransactionException.class , () -> account.withdraw(new BigDecimal(-50000)));
    }

    @Test
    public void should_not_withdraw_when_amount_is_zero() {
        UUID id = UUID.randomUUID();
        Account account = new AccountImpl(id, "Paul", new BigDecimal(1000), Instant.now(), new HashSet<>());
        assertThrows(NegativeAmountInTransactionException.class , () -> account.withdraw(new BigDecimal(0)));
    }

    @Test
    public void should_not_deposit_when_amount_is_zero() {
        UUID id = UUID.randomUUID();
        Account account = new AccountImpl(id, "Paul", new BigDecimal(1000), Instant.now(), new HashSet<>());
        assertThrows(NegativeAmountInTransactionException.class , () -> account.deposit(new BigDecimal(0)));
    }
    @Test
    public void should_not_deposit_when_amount_is_negative() {
        UUID id = UUID.randomUUID();
        Account account = new AccountImpl(id, "Paul", new BigDecimal(1000), Instant.now(), new HashSet<>());
        assertThrows(NegativeAmountInTransactionException.class , () -> account.deposit(new BigDecimal(-50000)));
    }

    @Test
    public void should_withdraw() {
        UUID id = UUID.randomUUID();
        Account account = new AccountImpl(id, "Paul", new BigDecimal(1000), Instant.now(), new HashSet<>());
        account.withdraw(new BigDecimal(500));
        assertEquals(account.getBalance(), new BigDecimal(500));
    }

    @Test
    public void should_deposit() {
        UUID id = UUID.randomUUID();
        Account account = new AccountImpl(id, "Paul", new BigDecimal(1000), Instant.now(), new HashSet<>());
        account.deposit(new BigDecimal(500));
        assertEquals(account.getBalance(), new BigDecimal(1500));
    }

}
