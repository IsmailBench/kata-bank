package org.exalt.exceptions;

public class NegativeAmountInTransactionException extends RuntimeException {
    public NegativeAmountInTransactionException() {
        super("Negative amount is forbidden");
    }
}
