package com.maternal.controle_estoques.mapper.model;

import com.maternal.controle_estoques.dto.ProductDTO;
import com.maternal.controle_estoques.model.Product;

public final class ProductMapper {

	private ProductMapper() {
	}

	public static Product dtoToEntity(ProductDTO dto) {
		return Product.ProductBuilder.builder()
			.productName(dto.productName())
			.productDescription(dto.productDescription())
			.productAmount(dto.productAmount())
			.productPrice(dto.productPrice())
			.build();
	}

	public static ProductDTO entityToDto(Product entity) {
		return new ProductDTO(entity.getProductName(), entity.getProductDescription(), entity.getProductPrice(), entity.getProductAmount());
	}
}
