package org.exalt.service;

import lombok.RequiredArgsConstructor;

import org.exalt.model.impl.OperationImpl;
import org.exalt.model.impl.OperationType;
import org.exalt.model.intf.Operation;
import org.exalt.port.driven.AccountPersistencePort;
import org.exalt.port.driving.DepositUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class DepositService implements DepositUseCase {
    private final AccountPersistencePort repository;

    @Override
    @Transactional
    public void deposit(UUID id, BigDecimal amount) {
        repository.findAccount(id).ifPresent(account -> {
            account.deposit(amount);
            Operation t = new OperationImpl(UUID.randomUUID(), amount, OperationType.DEPOSIT, Instant.now(), account.getBalance().subtract(amount));
            account.addOperation(t);
            repository.update(account);
        });
    }
}

