package com.maternal.controle_estoques.mapper;

import com.maternal.controle_estoques.dto.SupplierDTO;
import com.maternal.controle_estoques.model.Supplier;
import org.mapstruct.*;

import java.util.List;

/**
 * Interface responsável pelo mapeamento entre a entidade {@code Supplier} e o objeto de transferência de dados
 * {@code SupplierDTO}, utilizando o framework MapStruct. Este mapeador simplifica a conversão entre entidades
 * e DTOs, além de oferecer suporte para atualização parcial de entidades.
 *
 * <p>
 * A anotação {@code @Mapper} indica que esta interface será processada pelo MapStruct para geração automática
 * de uma implementação concreta em tempo de compilação. O modelo de componente está configurado como
 * {@code SPRING}, permitindo que a instância gerada seja gerenciada como um Bean pelo contexto do Spring.
 * Ademais, esta interface utiliza o mapeador {@link IAddressMapper} para lidar com o mapeamento de campos de endereço.
 * </p>
 *
 * <p>
 * Métodos disponíveis:
 * </p>
 * <ul>
 *   <li>
 *       <strong>{@code entityToDto(Supplier supplier)}</strong>: Converte uma entidade {@code Supplier}
 *       em um objeto {@code SupplierDTO}.
 *   </li>
 *   <li>
 *       <strong>{@code dtoToEntity(SupplierDTO supplierDTO)}</strong>: Converte um objeto {@code SupplierDTO}
 *       em uma entidade {@code Supplier}.
 *   </li>
 *   <li>
 *       <strong>{@code listEntityToListDto(List<Supplier> supplierList)}</strong>: Converte uma lista de entidades
 *       {@code Supplier} em uma lista de objetos {@code SupplierDTO}.
 *   </li>
 *   <li>
 *       <strong>{@code updateSupplier(SupplierDTO supplierDTO, @MappingTarget Supplier supplier)}</strong>:
 *       Atualiza os dados de uma entidade {@code Supplier} existente com base nas informações fornecidas
 *       em um {@code SupplierDTO}. Este método utiliza a estratégia de mapeamento
 *       {@code NullValuePropertyMappingStrategy.IGNORE}, permitindo que campos nulos no DTO não sobrescrevam os
 *       valores existentes na entidade.
 *   </li>
 * </ul>
 *
 * <p>
 * Este mapeador é especialmente útil em cenários que envolvem a manipulação de informações de fornecedores, garantindo que
 * as conversões necessárias entre as diferentes camadas da aplicação sejam consistentes, centralizadas e reutilizáveis.
 * Isso é essencial para aplicações que utilizam DTOs para abstrair detalhes das entidades de domínio, promovendo a aplicação
 * das melhores práticas no desenvolvimento de software.
 * </p>
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = IAddressMapper.class)
public interface ISupplierMapper {
	SupplierDTO entityToDto(Supplier supplier);
	Supplier dtoToEntity(SupplierDTO supplierDTO);
	List<SupplierDTO> listEntityToListDto(List<Supplier> supplierList);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateSupplier(SupplierDTO supplierDTO, @MappingTarget Supplier supplier);
}
