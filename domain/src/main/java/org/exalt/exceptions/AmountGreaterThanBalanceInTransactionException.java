package org.exalt.exceptions;

public class AmountGreaterThanBalanceInTransactionException extends RuntimeException{

    public AmountGreaterThanBalanceInTransactionException() {
        super("Amount is greater than balance");
    }

}
