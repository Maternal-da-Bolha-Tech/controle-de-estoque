package com.maternal.controle_estoques.service;

import com.maternal.controle_estoques.dto.ProductDTO;

public interface IProductService {
  ProductDTO insertNewProduct(ProductDTO newProduct);
}
