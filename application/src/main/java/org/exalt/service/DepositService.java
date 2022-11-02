package org.exalt.service;

import lombok.RequiredArgsConstructor;

import org.exalt.model.impl.TransactionImpl;
import org.exalt.model.impl.TransactionType;
import org.exalt.model.intf.Transaction;
import org.exalt.port.driven.AccountPersistencePort;
import org.exalt.port.driving.DepositUseCase;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
            Transaction t = new TransactionImpl(UUID.randomUUID(), amount, TransactionType.DEPOSIT, Instant.now(), account.getBalance().subtract(amount));
            account.addTransaction(t);
            repository.update(account);
        });
    }
}

