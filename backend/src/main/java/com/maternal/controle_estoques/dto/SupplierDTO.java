package com.maternal.controle_estoques.dto;

/**
 * Representa um objeto de transferência de dados (DTO) para fornecedores dentro do sistema.
 * <p>
 * O {@code SupplierDTO} é usado para encapsular e transferir informações sobre um fornecedor
 * entre diferentes camadas da aplicação. Este DTO garante que os dados do fornecedor sejam
 * padronizados e consistentes ao serem manipulados.
 * </p>
 * <p>
 * Os campos definidos no SupplierDTO incluem:
 * </p>
 * <ul>
 *   <li><strong>name</strong>: Nome do fornecedor.</li>
 *   <li><strong>cnpj</strong>: Número do Cadastro Nacional da Pessoa Jurídica (CNPJ) do fornecedor,
 *       utilizado para identificação legal no Brasil.</li>
 *   <li><strong>email</strong>: Endereço de e-mail para contato com o fornecedor.</li>
 *   <li><strong>phone</strong>: Número de telefone para comunicação com o fornecedor.</li>
 *   <li><strong>address</strong>: Informações completas de endereço do fornecedor, representado pelo {@link AddressDTO}.</li>
 * </ul>
 * <p>
 * Este DTO é útil para operações como listar fornecedores, adicionar novos fornecedores,
 * atualizar informações existentes e excluir fornecedores. Ele garante uma estrutura consistente
 * ao lidar com informações relacionadas aos fornecedores dentro do sistema.
 * </p>
 */
public record SupplierDTO(
	String name,
	String cnpj,
	String email,
	String phone,
	AddressDTO address
) {
}
