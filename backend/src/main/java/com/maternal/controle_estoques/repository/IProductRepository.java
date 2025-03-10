package com.maternal.controle_estoques.repository;

import com.maternal.controle_estoques.model.Product;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface de repositório para gerenciar entidades {@code Product} no sistema de inventário.
 * Esta interface estende JpaRepository para fornecer operações básicas de CRUD e métodos de consulta personalizados
 * para interagir com a tabela de banco de dados do produto.
 * <p>
 * O método {@code findProductByProductName} permite recuperar um produto com base no seu nome.
 * Restrições de validação garantem o manuseio correto da entrada ao rejeitar nomes de produtos em branco.
 * <p>
 * Métodos herdados do JpaRepository incluem:
 * <p>
 * - Operações de salvar, atualizar, deletar e buscar entidades {@code Product}.
 * <p>
 * As entidades retornadas ou gerenciadas por este repositório estão associadas à tabela {@code tb_product}.
 * Consultas personalizadas e validações garantirão a integridade dos dados e a conformidade com as regras de negócio.
 */
@Repository
public interface IProductRepository extends JpaRepository<Product, String> {
  Optional<Product> findProductByProductName(@NotBlank(message = "The name of the product should not be null and void.") String productName);
}
