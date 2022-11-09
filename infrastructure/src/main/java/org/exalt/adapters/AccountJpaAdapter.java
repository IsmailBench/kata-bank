package org.exalt.adapters;

import lombok.RequiredArgsConstructor;
import org.exalt.entities.AccountEntity;
import org.exalt.entities.OperationEntity;
import org.exalt.model.intf.Account;
import org.exalt.port.driven.AccountPersistencePort;
import org.exalt.repository.AccountEntityJpaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Database repository
 */

@RequiredArgsConstructor
@Repository
public class AccountJpaAdapter implements AccountPersistencePort {

    private final AccountEntityJpaRepository repository;
    private final ModelMapper modelMapper;


    /**
     * return an account for a given ID
     * @param id account ID
     * @return Optional<Account>
     */
    @Override
    public Optional<Account> findAccount(UUID id) {
        return repository.findById(id).map(AccountEntity::toDomain);
    }

    /**
     * update the account after any operation
     * @param account who will be updated
     */
    @Override
    public void update(Account account) {
        AccountEntity accountEntity = modelMapper.map(account, AccountEntity.class);
        Set<OperationEntity> operations = account.getOperationHistory()
                        .stream()
                        .map(operation -> modelMapper.map(operation, OperationEntity.class))
                        .collect(Collectors.toSet());
        accountEntity.setOperationEntities(operations);
        repository.save(accountEntity);

    }

}
