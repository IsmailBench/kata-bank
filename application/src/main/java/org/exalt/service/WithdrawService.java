package org.exalt.service;

import lombok.RequiredArgsConstructor;
import org.exalt.model.impl.OperationImpl;
import org.exalt.model.impl.OperationType;
import org.exalt.port.driven.AccountPersistencePort;
import org.exalt.port.driving.WithdrawUseCase;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
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
            OperationImpl t = new OperationImpl(UUID.randomUUID(), amount, OperationType.WITHDRAW, Instant.now(), account.getBalance().add(amount));
            account.addOperation(t);
            repository.update(account);
        });
    }
}
