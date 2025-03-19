package com.maternal.controle_estoques.builder.model;

import com.maternal.controle_estoques.builder.Builder;
import com.maternal.controle_estoques.model.Product;

import java.math.BigDecimal;

public interface ProductSpecificationBuilder extends Builder<Product> {

	ProductSpecificationBuilder productName(String name);

	ProductSpecificationBuilder productDescription(String productDescription);

	ProductSpecificationBuilder productPrice(BigDecimal productPrice);

	ProductSpecificationBuilder productAmount(Integer productAmount);
}
