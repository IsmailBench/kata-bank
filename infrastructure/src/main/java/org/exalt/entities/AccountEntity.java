package org.exalt.entities;

import lombok.*;
import org.exalt.model.impl.AccountImpl;
import org.exalt.model.intf.Account;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "account")
public class AccountEntity {
    @Id
    @Column(columnDefinition = "UUID")
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private UUID accountId;
    private String name;
    private BigDecimal balance;
    private Instant createAt;
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "account")
    private Set<OperationEntity> operationEntities;

    public static Account toDomain(AccountEntity accountEntity){
        return new AccountImpl(accountEntity.getAccountId(),accountEntity.getName(), accountEntity.getBalance(),
                accountEntity.getCreateAt(), accountEntity.getOperationEntities().stream().map(OperationEntity::toDomain).collect(Collectors.toSet()));
    }
}