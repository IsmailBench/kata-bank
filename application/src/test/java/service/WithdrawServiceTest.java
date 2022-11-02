
package service;

import org.exalt.model.impl.Account;
import org.exalt.port.driven.AccountPersistencePort;
import org.exalt.port.driving.WithdrawUseCase;
import org.exalt.service.WithdrawService;


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


public class WithdrawServiceTest {
    @MockBean
    private AccountPersistencePort repository;
    @MockBean
    private WithdrawUseCase service;

    @BeforeEach
    void init(){
        repository = mock(AccountPersistencePort.class);
        service = new WithdrawService(repository);
    }

    @Test
    public void should_withdraw_when_amount_is_lower_than_balance_and_add_transaction() {
        UUID id = UUID.randomUUID();
        Account account = new Account(id, "Paul", new BigDecimal(1000), Instant.now(), new HashSet<>());
        when(repository.findAccount(id)).thenReturn(Optional.of(account));
        repository.update(account);
        service.withdraw(account.getId(), new BigDecimal(500));
        assertEquals(account.getBalance(), new BigDecimal(500));
        assertEquals(account.getTransactionHistory().size(), 1);
    }


}

