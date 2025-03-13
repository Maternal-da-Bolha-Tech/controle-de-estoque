package com.maternal.controle_estoques.mapper;

import com.maternal.controle_estoques.dto.AddressDTO;
import com.maternal.controle_estoques.model.Address;
import org.mapstruct.*;

/**
 * Interface responsável pelo mapeamento entre a entidade {@code Address} e o objeto de transferência de dados
 * {@code AddressDTO}, utilizando o framework MapStruct. Este mapeador permite a conversão entre as representações
 * de entidades e DTOs, simplificando a manipulação de dados entre as diferentes camadas da aplicação.
 *
 * <p>
 * A anotação {@code @Mapper} especifica que esta interface será processada pelo MapStruct para gerar automaticamente
 * uma implementação concreta em tempo de compilação. O modelo de componente está configurado como {@code SPRING},
 * tornando a implementação gerenciada pelo contexto do Spring como um Bean.
 * </p>
 *
 * <p>
 * Métodos disponíveis:
 * </p>
 * <ul>
 *   <li>
 *       <strong>{@code entityToDto(Address address)}</strong>: Converte uma entidade {@code Address}
 *       em um DTO {@code AddressDTO}.
 *   </li>
 *   <li>
 *       <strong>{@code dtoToEntity(AddressDTO addressDTO)}</strong>: Converte um DTO {@code AddressDTO}
 *       em uma entidade {@code Address}.
 *   </li>
 *   <li>
 *       <strong>{@code updateAddress(AddressDTO addressDTO, @MappingTarget Address address)}</strong>:
 *       Atualiza os dados de uma entidade {@code Address} existente com base nos valores fornecidos em
 *       um {@code AddressDTO}. Este método utiliza a estratégia de mapeamento
 *       {@code NullValuePropertyMappingStrategy.IGNORE}, ignorando propriedades nulas no DTO.
 *   </li>
 * </ul>
 *
 * <p>
 * Este mapeador facilita a transferência de dados estruturados entre camadas, garantindo que as regras
 * de mapeamento sejam centralizadas, reutilizáveis e consistentes, especialmente em aplicações complexas que
 * utilizam objetos de transferência para abstrair os detalhes das entidades de domínio.
 * </p>
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IAddressMapper {
	AddressDTO entityToDto(Address address);
	Address dtoToEntity(AddressDTO addressDTO);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateAddress(AddressDTO addressDTO, @MappingTarget Address address);
}
