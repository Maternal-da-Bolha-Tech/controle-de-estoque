package com.maternal.controle_estoques.controller;

import com.maternal.controle_estoques.dto.ProductDTO;
import com.maternal.controle_estoques.model.Product;
import com.maternal.controle_estoques.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
  private final IProductService productService;

  public ProductController(IProductService productService) {
    this.productService = productService;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProductDTO> insertNewProduct(@RequestBody @Valid ProductDTO requestDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(this.productService.insertNewProduct(requestDto));
  }
}
