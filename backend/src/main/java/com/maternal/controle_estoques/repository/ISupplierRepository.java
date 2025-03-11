package com.maternal.controle_estoques.repository;

import com.maternal.controle_estoques.model.Supplier;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * <p>Interface de repositório que gerencia as operações de persistência relacionadas à entidade {@link Supplier}.
 * Estende a interface {@link JpaRepository} para herdar funcionalidades padrão de CRUD.</p>
 *
 * <p>Oferece métodos adicionais para manipular fornecedores com base em suas propriedades específicas, como o nome.</p>
 *
 * <ul>
 *   <li><b>findSupplierByName:</b> Recupera um fornecedor baseado no nome fornecido.</li>
 *   <li><b>deleteSupplierByName:</b> Exclui um fornecedor baseado no nome fornecido.</li>
 * </ul>
 *
 * <p><b>Nota:</b> Os parâmetros utilizados em métodos customizados possuem validação para garantir que não são nulos nem vazios.</p>
 */
@Repository
public interface ISupplierRepository extends JpaRepository<Supplier, String> {
	Optional<Supplier> findSupplierByName(@NotBlank(message = "The supplier's name cannot be null and void.") String name);
	void deleteSupplierByName(@NotBlank(message = "The supplier's name cannot be null and void.") String name);
}
