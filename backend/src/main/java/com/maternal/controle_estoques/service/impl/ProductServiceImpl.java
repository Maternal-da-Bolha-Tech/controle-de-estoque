package com.maternal.controle_estoques.service.impl;

import com.maternal.controle_estoques.dto.ProductDTO;
import com.maternal.controle_estoques.mapper.IProductMapper;
import com.maternal.controle_estoques.model.Product;
import com.maternal.controle_estoques.repository.IProductRepository;
import com.maternal.controle_estoques.service.IProductService;
import org.springframework.stereotype.Service;

/**
 * Implementa a interface para lidar com a lógica de negócios para o gerenciamento de entidades de produtos.
 * Esta classe atua como um intermediário entre o repositório de dados e a lógica de aplicação, aproveitando
 * o repositório e o mapeador para realizar operações com entidades de produtos e seus DTOs.
 * <p>
 * Responsabilidades incluem:
 * - Gerenciar e persistir novos produtos no inventário.
 * - Garantir o mapeamento preciso entre produtos e seus DTOs.
 */
@Service
public class ProductServiceImpl implements IProductService {
  private final IProductRepository productRepository;
  private final IProductMapper productMapper;

  public ProductServiceImpl(IProductRepository productRepository, IProductMapper productMapper) {
    this.productRepository = productRepository;
    this.productMapper = productMapper;
  }

  @Override
  public ProductDTO insertNewProduct(ProductDTO newProduct) {
    Product productSaved = this.productRepository.save(this.productMapper.DtoToEntity(newProduct));
    return this.productMapper.entityToDto(productSaved);
  }
}
