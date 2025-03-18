package com.maternal.controle_estoques.repository;

import com.maternal.controle_estoques.model.Product;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, String> {
  Optional<Product> findProductByProductName(@NotBlank(message = "The name of the product should not be null and void.") String productName);
}
