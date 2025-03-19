package com.maternal.controle_estoques.controller;

import com.maternal.controle_estoques.dto.ProductDTO;
import com.maternal.controle_estoques.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe controladora responsável por lidar com requisições HTTP relacionadas às operações de produtos.
 * Esta classe atua como um ponto de entrada para os clientes e delega a lógica de negócio para a camada de serviço.
 * <p>
 * A controladora oferece APIs REST para gerenciar produtos, incluindo operações como a inserção de um novo produto.
 * Ela garante a validação adequada dos dados de entrada e retorna respostas apropriadas para os clientes.
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {
	private final IProductService productService;

	public ProductController(IProductService productService) {
		this.productService = productService;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDTO> insertNewProduct(@RequestBody @Valid ProductDTO newProduct) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.productService.insertNewProduct(newProduct));
	}
}
