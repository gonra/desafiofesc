package org.gonra.desafio.repository;

import java.util.*;

import org.gonra.desafio.entities.Operation;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

    @Query("select o from Operation o where o.product.id = :productId")
    List<Operation> findByProductId(Long productId);

    @Query("select o from Operation o where o.typeOperation.id = :operationId")
    List<Operation> findByTypeOperationId(Long operationId);

    @Query("select o from Operation o where o.product.id = :productId and o.typeOperation.id = :operationId")
    List<Operation> findByProductIdandTypeOperationId(Long productId, Long operationId);

}
