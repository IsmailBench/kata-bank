
package service;

import org.exalt.model.impl.Account;

import org.exalt.port.driven.AccountPersistencePort;
import org.exalt.port.driving.DepositUseCase;
import org.exalt.service.DepositService;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DepositServiceTest {
    @MockBean
    private AccountPersistencePort repository;
    @MockBean
    private DepositUseCase service;
    @BeforeEach
    void init(){
        repository = mock(AccountPersistencePort.class);
        service = new DepositService(repository);
    }
    @Test
    public void should_deposit_and_add_transaction() {
        UUID id = UUID.randomUUID();
        Account account = new Account(id, "Paul", new BigDecimal(1000), Instant.now(), new HashSet<>());
        when(repository.findAccount(id)).thenReturn(Optional.of(account));
        service.deposit(id, new BigDecimal(500));
        assertEquals(account.getBalance(), new BigDecimal(1500));
        assertEquals(account.getTransactionHistory().size(), 1);
    }

}

