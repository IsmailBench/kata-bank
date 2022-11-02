package org.exalt.model;


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
        AccountImpl accountImpl = new AccountImpl(id, "Paul", new BigDecimal(1000), Instant.now(), new HashSet<>());
        assertThrows(AmountGreaterThanBalanceInTransactionException.class , () -> accountImpl.withdraw(new BigDecimal(50000)));
    }

    @Test
    public void should_not_withdraw_when_amount_is_negative() {
        UUID id = UUID.randomUUID();
        AccountImpl accountImpl = new AccountImpl(id, "Paul", new BigDecimal(1000), Instant.now(), new HashSet<>());
        assertThrows(NegativeAmountInTransactionException.class , () -> accountImpl.withdraw(new BigDecimal(-50000)));
    }

    @Test
    public void should_not_depoosit_when_amount_is_negative() {
        UUID id = UUID.randomUUID();
        AccountImpl accountImpl = new AccountImpl(id, "Paul", new BigDecimal(1000), Instant.now(), new HashSet<>());
        assertThrows(NegativeAmountInTransactionException.class , () -> accountImpl.deposit(new BigDecimal(-50000)));
    }

    @Test
    public void should_withdraw() {
        UUID id = UUID.randomUUID();
        AccountImpl accountImpl = new AccountImpl(id, "Paul", new BigDecimal(1000), Instant.now(), new HashSet<>());
        accountImpl.withdraw(new BigDecimal(500));
        assertEquals(accountImpl.getBalance(), new BigDecimal(500));

    }

    @Test
    public void should_deposit() {
        UUID id = UUID.randomUUID();
        AccountImpl accountImpl = new AccountImpl(id, "Paul", new BigDecimal(1000), Instant.now(), new HashSet<>());
        accountImpl.deposit(new BigDecimal(500));
        assertEquals(accountImpl.getBalance(), new BigDecimal(1500));
    }

}
