package org.exalt.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class AccountResponse {
    private final String name;
    private final BigDecimal balance;

    public AccountResponse(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance;
    }
}
