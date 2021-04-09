package org.gonra.desafio.repository;

import org.gonra.desafio.entities.Operation;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

}
