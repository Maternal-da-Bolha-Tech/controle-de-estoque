package com.maternal.controle_estoques.service.impl;

import com.maternal.controle_estoques.dto.SupplierDTO;
import com.maternal.controle_estoques.mapper.ISupplierMapper;
import com.maternal.controle_estoques.model.Supplier;
import com.maternal.controle_estoques.repository.ISupplierRepository;
import com.maternal.controle_estoques.service.ISupplierService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Implementação da interface {@link ISupplierService} responsável por gerenciar a lógica de negócios
 * relacionada a fornecedores no contexto do sistema de controle de estoques.</p>
 *
 * <p>Esta classe encapsula a lógica necessária para as operações de fornecedores, incluindo listagem,
 * criação, atualização e exclusão de registros. Utiliza os componentes {@link ISupplierRepository} e
 * {@link ISupplierMapper} para acessar a camada de persistência e realizar as transformações entre
 * entidades e DTOs.</p>
 *
 * <p>Principais responsabilidades da classe:</p>
 * <ul>
 *   <li><b>Listar fornecedores:</b> Recupera a lista de todos os fornecedores cadastrados no sistema.</li>
 *   <li><b>Criar novo fornecedor:</b> Insere um novo fornecedor utilizando um objeto {@code SupplierDTO}.</li>
 *   <li><b>Atualizar fornecedor existente:</b> Atualiza os dados de um fornecedor identificado pelo nome fornecido.</li>
 *   <li><b>Excluir fornecedor:</b> Remove do sistema um fornecedor com base no nome informado.</li>
 * </ul>
 *
 * <p>A implementação utiliza a anotação {@code @Transactional} para garantir que as operações de
 * atualização e exclusão sejam realizadas dentro de um ambiente transacional, assegurando consistência
 * e integridade dos dados.</p>
 *
 * <p><b>Componentes utilizados:</b></p>
 * <ul>
 *   <li>{@link ISupplierRepository}: Para acessar e manipular os dados persistidos de fornecedores.</li>
 *   <li>{@link ISupplierMapper}: Para converter objetos {@code Supplier} em {@code SupplierDTO} e vice-versa.</li>
 * </ul>
 *
 * <p><b>Nota:</b> Exceções podem ser lançadas para indicar erros específicos, como:
 * <ul>
 *   <li>Fornecedores não encontrados ao tentar atualizar ou excluir pelo nome.</li>
 *   <li>Problemas de persistência durante as operações de inserção ou atualização.</li>
 * </ul>
 * </p>
 */
@Service
public class SupplierServiceImpl implements ISupplierService {
	private final ISupplierRepository supplierRepository;
	private final ISupplierMapper supplierMapper;

	public SupplierServiceImpl(ISupplierRepository supplierRepository, ISupplierMapper supplierMapper) {
		this.supplierRepository = supplierRepository;
		this.supplierMapper = supplierMapper;
	}

	@Override
	public List<SupplierDTO> listALl() {
		return this.supplierMapper.listEntityToListDto(this.supplierRepository.findAll());
	}

	@Override
	@Transactional
	public void insertNewSupplier(SupplierDTO newSupplier) {
		Supplier supplierToSave = this.supplierMapper.dtoToEntity(newSupplier);
		this.supplierRepository.save(supplierToSave);
	}

	@Override
	@Transactional
	public void updateSupplier(String name, SupplierDTO supplierDTO) {
		Supplier supplierSaved = this.supplierRepository.findSupplierByName(name).orElseThrow();
		this.supplierMapper.updateSupplier(supplierDTO, supplierSaved);
		this.supplierRepository.save(supplierSaved);
	}

	@Override
	@Transactional
	public void deleteSupplier(String name) {
		this.supplierRepository.deleteSupplierByName(name);
	}
}
