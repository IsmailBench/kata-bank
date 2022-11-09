package org.exalt.exceptions;

public class AmountGreaterThanBalanceInOperationException extends RuntimeException{

    public AmountGreaterThanBalanceInOperationException() {
        super("Amount is greater than balance");
    }

}
