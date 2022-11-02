package org.exalt.port.driven;



import org.exalt.model.intf.Account;

import java.util.Optional;
import java.util.UUID;

public interface AccountPersistencePort {
    Optional<Account> findAccount(UUID id);
    void update(Account account);
}
