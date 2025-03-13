package com.maternal.controle_estoques.controller;

import com.maternal.controle_estoques.dto.SupplierDTO;
import com.maternal.controle_estoques.service.ISupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Classe controladora responsável por lidar com requisições HTTP relacionadas às operações de fornecedores.
 * Esta classe atua como um ponto de entrada para os clientes e delega a lógica de negócio para a camada de serviço
 * {@code ISupplierService}.
 *
 * <p>Principais funcionalidades oferecidas por este controlador:</p>
 * <ul>
 *   <li>Buscar todos os fornecedores cadastrados.</li>
 *   <li>Inserir um novo fornecedor no sistema.</li>
 *   <li>Atualizar os dados de um fornecedor baseado no nome.</li>
 *   <li>Remover um fornecedor baseado no nome.</li>
 * </ul>
 *
 * <p>Os métodos aqui definidos utilizam os seguintes mapeamentos para interação HTTP:</p>
 * <ul>
 *   <li>{@code @GetMapping}: Para buscar informações.</li>
 *   <li>{@code @PostMapping}: Para inserir novos dados.</li>
 *   <li>{@code @PatchMapping}: Para atualizar informações existentes.</li>
 *   <li>{@code @DeleteMapping}: Para excluir registros.</li>
 * </ul>
 *
 * <p>O controlador retorna respostas apropriadas conforme o estado da operação:</p>
 * <ul>
 *   <li>{@code HttpStatus.OK}: Para operações de consulta realizadas com sucesso.</li>
 *   <li>{@code HttpStatus.CREATED}: Para inserções realizadas com sucesso.</li>
 *   <li>{@code HttpStatus.NO_CONTENT}: Para atualizações e exclusões realizadas com sucesso.</li>
 * </ul>
 *
 * <p>A classe utiliza o DTO {@code SupplierDTO} para transferir os dados de fornecedores
 * entre as camadas de controlador e serviço.</p>
 */
@RestController
@RequestMapping(value = "/supplier")
public class SupplierController {
	private final ISupplierService supplierService;

	public SupplierController(ISupplierService supplierService) {
		this.supplierService = supplierService;
	}

	@GetMapping(value = "/all", produces = "application/json")
	public ResponseEntity<List<SupplierDTO>> getAllSupplier() {
		List<SupplierDTO> supplierList = this.supplierService.listALl();
		return ResponseEntity.status(HttpStatus.OK).body(supplierList);
	}

	@PostMapping(value = "/insert", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Void> insertNewSupplier(@RequestBody SupplierDTO supplierDTO) {
		this.supplierService.insertNewSupplier(supplierDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PatchMapping(value = "/update", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Void> updateSupplier(@RequestParam String name, @RequestBody SupplierDTO supplierDTO) {
		this.supplierService.updateSupplier(name, supplierDTO);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@DeleteMapping(value = "/delete", produces = "application/json")
	public ResponseEntity<Void> deleteSupplier(@RequestParam String name) {
		this.supplierService.deleteSupplier(name);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
