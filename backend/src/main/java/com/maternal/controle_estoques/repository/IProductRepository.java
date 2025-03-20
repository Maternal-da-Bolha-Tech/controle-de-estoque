package com.maternal.controle_estoques.repository;

import com.maternal.controle_estoques.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IProductRepository extends JpaRepository<Product, String> {

	@Query("SELECT p FROM Product p WHERE UPPER(p.productName) LIKE UPPER(CONCAT('%', :productName, '%'))")
	Optional<Product> findProductByProductName(String productName);
}
