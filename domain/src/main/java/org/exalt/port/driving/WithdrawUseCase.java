package org.exalt.port.driving;

import java.math.BigDecimal;
import java.util.UUID;

public interface WithdrawUseCase {
    void withdraw(UUID id, BigDecimal amount);
}
