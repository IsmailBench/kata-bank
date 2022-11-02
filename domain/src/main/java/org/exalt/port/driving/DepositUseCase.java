package org.exalt.port.driving;

import java.math.BigDecimal;
import java.util.UUID;

public interface DepositUseCase {
    void deposit(UUID id, BigDecimal amount);
}
