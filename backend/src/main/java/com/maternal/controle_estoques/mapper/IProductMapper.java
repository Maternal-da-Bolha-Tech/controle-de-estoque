package com.maternal.controle_estoques.mapper;

import com.maternal.controle_estoques.dto.ProductDTO;
import com.maternal.controle_estoques.model.Product;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * Esta interface define um mapeador para conversão entre entidades Product e objetos ProductDTO.
 * Ela é usada para implementar a conversão de estruturas complexas de entidade e DTO de maneira consistente.
 * A anotação @Mapper do framework MapStruct é utilizada para gerar a implementação em tempo de execução.
 * O modelo de componente é definido como Spring, tornando este mapeador gerenciado como um Bean do Spring.
 * <p>
 * Métodos incluídos nesta interface:
 * - `entityToDto(Product product)`: Converte uma entidade Product em um objeto ProductDTO.
 * - `DtoToEntity(ProductDTO productDTO)`: Converte um objeto ProductDTO em uma entidade Product.
 * <p>
 * A validação de entrada é realizada utilizando anotações como @Valid, garantindo a conformidade com
 * as estruturas e restrições definidas nas classes Product e ProductDTO.
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IProductMapper {
  ProductDTO entityToDto(@Valid Product product);
  Product DtoToEntity(@Valid ProductDTO productDTO);
}
