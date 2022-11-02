package org.exalt.port.driving;


import org.exalt.model.intf.Account;
import org.exalt.model.intf.Transaction;

import java.util.Set;
import java.util.UUID;

public interface AccountUseCase {
    /**
     *
     * @param id an UUID as id
     * @return an account for the given account ID
     */
    Account getAccount(UUID id);

    /**
     *
     * @param id id an UUID as id
     * @return a Set of transaction for the given account ID
     */
    Set<Transaction> getTransactions(UUID id);
}
