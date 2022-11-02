package org.exalt.port.driving;


import org.exalt.model.intf.Account;
import org.exalt.model.intf.Transaction;

import java.util.Set;
import java.util.UUID;

public interface AccountUseCase {
    Account getAccount(UUID id);
    Set<Transaction> getTransactions(UUID id);
}
