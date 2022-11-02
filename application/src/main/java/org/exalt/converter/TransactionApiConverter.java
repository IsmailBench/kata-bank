package org.exalt.converter;

import lombok.experimental.UtilityClass;
import org.exalt.dto.TransactionResponse;
import org.exalt.model.intf.Transaction;

@UtilityClass
public class TransactionApiConverter {


    public static TransactionResponse toTransactionResponse(final Transaction transaction){
        TransactionResponse test = new TransactionResponse(transaction.getAmount(), transaction.getTransactionType(), transaction.getBalance(), transaction.getCreatedAt());
        return new TransactionResponse(transaction.getAmount(), transaction.getTransactionType(), transaction.getBalance(), transaction.getCreatedAt());
    }

}
