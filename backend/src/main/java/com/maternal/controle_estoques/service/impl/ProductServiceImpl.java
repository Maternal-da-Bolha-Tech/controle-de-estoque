package com.maternal.controle_estoques.service.impl;

import com.maternal.controle_estoques.dto.ProductDTO;
import com.maternal.controle_estoques.mapper.IProductMapper;
import com.maternal.controle_estoques.model.Product;
import com.maternal.controle_estoques.repository.IProductRepository;
import com.maternal.controle_estoques.service.IProductService;
import org.springframework.stereotype.Service;

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
