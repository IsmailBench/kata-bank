package org.exalt.model.intf;


import org.exalt.model.impl.OperationType;

import java.math.BigDecimal;
import java.time.Instant;

public interface Operation {
    BigDecimal getAmount();
    BigDecimal getBalance();
    Instant getCreatedAt();
    OperationType getOperationType();

}
