package org.exalt.service;

import lombok.RequiredArgsConstructor;
import org.exalt.model.impl.TransactionImpl;
import org.exalt.model.impl.TransactionType;
import org.exalt.port.driven.AccountPersistencePort;
import org.exalt.port.driving.WithdrawUseCase;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class WithdrawService implements WithdrawUseCase {

    private final AccountPersistencePort repository;

    @Override
    @Transactional
    public void withdraw(UUID id, BigDecimal amount) {
        repository.findAccount(id).ifPresent(account -> {
            account.withdraw(amount);
            TransactionImpl t = new TransactionImpl(UUID.randomUUID(), amount, TransactionType.WITHDRAW, Instant.now(), account.getBalance().add(amount));
            account.addTransaction(t);
            repository.update(account);
        });
    }
}
