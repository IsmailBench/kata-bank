package org.exalt.repository;

import org.exalt.entities.AccountEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountEntityJpaRepository extends JpaRepository<AccountEntity, UUID> {

}
