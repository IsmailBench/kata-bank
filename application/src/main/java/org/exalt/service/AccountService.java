package org.exalt.service;


import lombok.RequiredArgsConstructor;
import org.exalt.exceptions.AccountNotFoundException;
import org.exalt.model.intf.Account;
import org.exalt.model.intf.Transaction;
import org.exalt.port.driven.AccountPersistencePort;
import org.exalt.port.driving.AccountUseCase;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Service class with different domain function
 */
@RequiredArgsConstructor
@Service
public class AccountService implements AccountUseCase {

    private final AccountPersistencePort repository;


    @Override
    public Account getAccount(UUID id) {
        return repository.findAccount(id).<AccountNotFoundException>orElseThrow(() -> {
            throw new AccountNotFoundException("Account Not found");
        });

    }


    @Override
    @Transactional
    public Set<Transaction> getTransactions(UUID id) {
        return repository.findAccount(id)
                .map(Account::getTransactionHistory)
                .stream()
                .flatMap(Set::stream).collect(Collectors.toSet());
    }
}
