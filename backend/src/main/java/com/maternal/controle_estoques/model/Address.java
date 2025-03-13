package com.maternal.controle_estoques.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Representa uma entidade de endereço no sistema.
 * Esta classe é mapeada para a tabela do banco de dados {@code tb_address} utilizando as anotações JPA.
 * <p>
 * Contém informações relacionadas a endereços, como nome da rua, número, cidade, estado, CEP e país.
 * Cada atributo possui restrições de validação definidas para garantir consistência e integridade dos dados.
 * <p>
 * Os principais atributos da classe incluem:
 * <ul>
 *   <li>{@code streetName}: Nome da rua, obrigatório, não pode ser nulo ou vazio.</li>
 *   <li>{@code streetNumber}: Número da rua, obrigatório, não pode ser nulo.</li>
 *   <li>{@code city}: Cidade, obrigatória, não pode ser nula ou vazia.</li>
 *   <li>{@code state}: Estado, obrigatório, não pode ser nulo ou vazio.</li>
 *   <li>{@code zipCode}: Código postal (CEP), obrigatório, não pode ser nulo ou vazio.</li>
 *   <li>{@code country}: País, obrigatório, não pode ser nulo ou vazio.</li>
 * </ul>
 * <p>
 * Também substitui os métodos {@code equals} e {@code hashCode} para determinar igualdade
 * com base nos atributos {@code streetName}, {@code streetNumber} e {@code zipCode}.
 */
@Entity(name = "address")
@Table(name = "tb_address")
public class Address {

	@Id
	@NotBlank(message = "Street name cannot be null and void.")
	@Column(name = "address_street_name")
	private String streetName;

	@NotNull(message = "Street number cannot be null.")
	@Column(name = "address_street_number")
	private Integer streetNumber;

	@NotBlank(message = "City cannot be null and void.")
	@Column(name = "address_city")
	private String city;

	@NotBlank(message = "State cannot be null and void.")
	@Column(name = "address_state")
	private String state;

	@NotBlank(message = "Zip code cannot be null and void.")
	@Column(name = "address_zipcode")
	private String zipCode;

	@NotBlank(message = "Country cannot be null and void.")
	@Column(name = "address_country")
	private String country;

	public Address() {
	}

	public Address(String streetName, Integer streetNumber, String city, String state, String zipCode, String country) {
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public Integer getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(Integer streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;

		Address address = (Address) o;
		return streetName.equals(address.streetName) && streetNumber.equals(address.streetNumber) && zipCode.equals(address.zipCode);
	}

	@Override
	public int hashCode() {
		int result = streetName.hashCode();
		result = 31 * result + streetNumber.hashCode();
		result = 31 * result + zipCode.hashCode();
		return result;
	}
}
