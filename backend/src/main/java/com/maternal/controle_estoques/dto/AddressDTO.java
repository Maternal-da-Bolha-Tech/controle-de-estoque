package com.maternal.controle_estoques.dto;

/**
 * Representa um objeto de transferência de dados (DTO) para endereços dentro do sistema.
 * <p>
 * Este DTO encapsula as informações detalhadas necessárias para identificar e representar um endereço
 * em diferentes camadas da aplicação, garantindo a padronização e a clareza dos dados transmitidos.
 * </p>
 * <p>
 * Os campos definidos no registro AddressDTO incluem:
 * </p>
 * <ul>
 *   <li><strong>streetName</strong>: Nome da rua associada ao endereço.</li>
 *   <li><strong>streetNumber</strong>: Número do estabelecimento ou residência na rua especificada.</li>
 *   <li><strong>city</strong>: Cidade onde o endereço está localizado.</li>
 *   <li><strong>state</strong>: Estado correspondente ao endereço.</li>
 *   <li><strong>zipCode</strong>: Código postal (CEP) relacionado ao endereço.</li>
 *   <li><strong>country</strong>: País de localização do endereço.</li>
 * </ul>
 * <p>
 * Este DTO pode ser usado em diferentes contextos, como no mapeamento de entidades, transferência de
 * dados entre layers, integração com APIs externas, entre outros, fornecendo uma representação confiável
 * das informações de endereço em uma aplicação empresarial.
 * </p>
 */
public record AddressDTO(
	String streetName,
	Integer streetNumber,
	String city,
	String state,
	String zipCode,
	String country
) {
}
