package org.exalt.exceptions;

public class NegativeAmountInOperationException extends RuntimeException {
    public NegativeAmountInOperationException() {
        super("Negative amount is forbidden");
    }
}
