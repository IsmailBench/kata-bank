package org.exalt.port.driving;

import java.math.BigDecimal;
import java.util.UUID;

public interface DepositUseCase {
    /**
     * @param id  an UUID as account id
     * @param amount to be transferred to the account
     */
    void deposit(UUID id, BigDecimal amount);
}
