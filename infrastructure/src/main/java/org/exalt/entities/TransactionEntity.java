package org.exalt.entities;

import lombok.*;
import org.exalt.model.impl.TransactionImpl;
import org.exalt.model.impl.TransactionType;
import org.exalt.model.intf.Transaction;

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
@Table(name = "transaction")
public class TransactionEntity {
    @Id
    @Column(columnDefinition = "UUID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID transactionId;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private Instant createAt;
    private BigDecimal balance;


    public static Transaction toDomain(TransactionEntity transactionEntity) {
    return new TransactionImpl(transactionEntity.transactionId, transactionEntity.getAmount(),
                transactionEntity.getTransactionType(), transactionEntity.getCreateAt(), transactionEntity.getBalance());
    }
}
