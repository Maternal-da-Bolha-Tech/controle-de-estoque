package com.maternal.controle_estoques.service;

import com.maternal.controle_estoques.dto.SupplierDTO;

import java.util.List;

/**
 * Interface de serviço para gerenciar operações relacionadas a fornecedores no sistema de controle de estoques.
 * <p>
 * Esta interface fornece os métodos necessários para gerenciar a lógica de negócios associada a fornecedores,
 * incluindo listagem, criação, atualização e exclusão de fornecedores. É responsável por encapsular as operações
 * realizadas no nível de serviço e garantir que as regras de negócio sejam respeitadas nas operações associadas
 * a entidades de fornecedores.
 * </p>
 *
 * <p>
 * Resumo dos métodos disponíveis:
 * </p>
 * <ul>
 *   <li><strong>{@code listALl()}</strong>: Recupera uma lista de todos os fornecedores cadastrados no sistema.</li>
 *   <li><strong>{@code insertNewSupplier(SupplierDTO newSupplier)}</strong>: Adiciona um novo fornecedor no sistema,
 *       recebendo um objeto {@code SupplierDTO} como parâmetro.</li>
 *   <li><strong>{@code updateSupplier(String name, SupplierDTO supplierDTO)}</strong>: Atualiza as informações de um
 *       fornecedor existente, identificado por seu nome, com os novos dados fornecidos através de um
 *       objeto {@code SupplierDTO}.</li>
 *   <li><strong>{@code deleteSupplier(String name)}</strong>: Remove um fornecedor existente do sistema com base
 *       no seu nome.</li>
 * </ul>
 *
 * <p>
 * As implementações desta interface devem garantir:
 * </p>
 * <ul>
 *   <li>Validação e consistência dos dados enviados para a criação e atualização de fornecedores.</li>
 *   <li>Garantia de que os fornecedores sejam corretamente mapeados entre entidades de dados e DTOs.</li>
 *   <li>Integração eficaz com as camadas de repositório para persistência e manipulação dos dados de fornecedores.</li>
 * </ul>
 */
public interface ISupplierService {
	List<SupplierDTO> listALl();
	void insertNewSupplier(SupplierDTO newSupplier);
	void updateSupplier(String name, SupplierDTO supplierDTO);
	void deleteSupplier(String name);
}
