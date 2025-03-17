package com.maternal.controle_estoques.mapper;

import com.maternal.controle_estoques.dto.ProductDTO;
import com.maternal.controle_estoques.model.Product;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IProductMapper {
  ProductDTO entityToDto(@Valid Product product);
  Product DtoToEntity(@Valid ProductDTO productDTO);
}
