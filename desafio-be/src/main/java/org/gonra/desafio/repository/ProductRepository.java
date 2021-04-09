package org.gonra.desafio.repository;

import java.util.List;

import org.gonra.desafio.entities.Product;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.typeProduct.id = :typeProductId")
    List<Product> findByTypeProductId(Long typeProductId);

}
