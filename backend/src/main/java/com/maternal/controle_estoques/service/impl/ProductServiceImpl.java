package com.maternal.controle_estoques.service.impl;

import com.maternal.controle_estoques.dto.ProductDTO;
import com.maternal.controle_estoques.mapper.model.ProductMapper;
import com.maternal.controle_estoques.model.Product;
import com.maternal.controle_estoques.repository.IProductRepository;
import com.maternal.controle_estoques.service.IProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {
  private final IProductRepository productRepository;

  public ProductServiceImpl(IProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public ProductDTO insertNewProduct(ProductDTO requestDto) {
    Product productSaved = this.productRepository.save(ProductMapper.dtoToEntity(requestDto));
    return ProductMapper.entityToDto(productSaved);
  }
}
