package org.exalt.adapters;

import org.exalt.entities.AccountEntity;
import org.exalt.model.impl.AccountImpl;
import org.exalt.model.intf.Account;
import org.exalt.repository.AccountEntityJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class AccountImplJpaAdapterTest {
    @MockBean
    private AccountJpaAdapter adapter;
    @MockBean
    private AccountEntityJpaRepository repository;
    @MockBean
    private ModelMapper modelMapper;
    @MockBean
    private Account account;
    @MockBean
    private AccountEntity accountEntity;
    private UUID id;

    @BeforeEach
    public void init() {
        id = UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898");
        account = new AccountImpl(id, "Paul", new BigDecimal(1000), Instant.now(), new HashSet<>());
        accountEntity = new AccountEntity(id, "Paul", new BigDecimal(1000), Instant.now(), new HashSet<>());
        repository = mock(AccountEntityJpaRepository.class);
        repository.save(accountEntity);
        modelMapper = mock(ModelMapper.class);
        adapter = new AccountJpaAdapter(repository, modelMapper);
    }

    @Test
    public void should_find_account() {
        when(modelMapper.map(org.mockito.ArgumentMatchers.any(), org.mockito.ArgumentMatchers.any())).thenReturn(account);
        when(repository.findById(id)).thenReturn(Optional.of(accountEntity));
        assertNotNull(adapter.findAccount(id));
        assertEquals(adapter.findAccount(id).get().getName(), "Paul");
        assertEquals(adapter.findAccount(id).get().getId(), UUID.fromString("a5764857-ae35-34dc-8f25-a9c9e73aa898"));
        assertEquals(adapter.findAccount(id).get().getBalance(), new BigDecimal(1000));
    }

}
