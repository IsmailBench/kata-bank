package org.exalt.repository;

import org.exalt.entities.AccountEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface AccountEntityJpaRepository extends JpaRepository<AccountEntity, UUID> {

}
