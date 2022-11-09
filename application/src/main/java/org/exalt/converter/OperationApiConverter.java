package org.exalt.converter;

import lombok.experimental.UtilityClass;
import org.exalt.dto.OperationResponse;
import org.exalt.model.intf.Operation;

@UtilityClass
public class OperationApiConverter {


    public static OperationResponse toOperationResponse(final Operation operation){
        return new OperationResponse(operation.getAmount(), operation.getOperationType(), operation.getBalance(), operation.getCreatedAt());
    }

}
