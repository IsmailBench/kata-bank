package org.exalt.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class WithdrawRequest {
    private UUID id;
    private BigDecimal amount;
}
