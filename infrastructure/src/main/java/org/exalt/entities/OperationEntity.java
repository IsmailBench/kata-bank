package org.exalt.entities;

import lombok.*;
import org.exalt.model.impl.OperationImpl;
import org.exalt.model.impl.OperationType;
import org.exalt.model.intf.Operation;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "operation")
public class OperationEntity {
    @Id
    @Column(columnDefinition = "UUID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID operationId;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private OperationType operationType;
    private Instant createAt;
    private BigDecimal balance;


    public static Operation toDomain(OperationEntity operationEntity) {
    return new OperationImpl(operationEntity.operationId, operationEntity.getAmount(),
                operationEntity.getOperationType(), operationEntity.getCreateAt(), operationEntity.getBalance());
    }
}
