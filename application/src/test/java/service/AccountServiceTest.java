
package service;

import org.exalt.model.impl.Account;


import org.exalt.port.driven.AccountPersistencePort;
import org.exalt.port.driving.AccountUseCase;
import org.exalt.service.AccountService;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountServiceTest {
    @MockBean
    private AccountPersistencePort repository;
    @MockBean
    private AccountUseCase service;
    @BeforeEach
    void init(){
        repository = mock(AccountPersistencePort.class);
        service = new AccountService(repository);
    }
    @Test
    public void should_return_bankaccount() {
        UUID id = UUID.randomUUID();
        Account account = new Account(id, "Paul", new BigDecimal(1000), Instant.now(), new HashSet<>());
        when(repository.findAccount(id)).thenReturn(Optional.of(account));
        org.exalt.model.intf.Account testAccount = service.getAccount(id);
        assertNotNull(testAccount);
    }

}

