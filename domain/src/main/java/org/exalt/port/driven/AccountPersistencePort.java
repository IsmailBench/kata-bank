package org.exalt.port.driven;



import org.exalt.model.intf.Account;

import java.util.Optional;
import java.util.UUID;

public interface AccountPersistencePort {
    /**
     *
     * @param id an UUID as account ID
     * @return a account for the specified account ID
     */
    Optional<Account> findAccount(UUID id);

    /**
     * Update an account
     * @param account to update
     */
    void update(Account account);
}
