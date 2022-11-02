package org.exalt.port.driving;

import java.math.BigDecimal;
import java.util.UUID;

public interface WithdrawUseCase {
    /**
     *
     * @param id  an UUID as account id
     * @param amount to be transferred to the account
     */
    void withdraw(UUID id, BigDecimal amount);
}
