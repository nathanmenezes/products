package br.com.omotor.produtosapi.repository;

import br.com.omotor.produtosapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByName(String name);
    boolean existsByQuantity(Integer quantity);
    boolean existsByPrice(Double price);
}
