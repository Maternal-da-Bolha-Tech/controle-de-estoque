package com.maternal.controle_estoques.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 * <p>Representa um fornecedor armazenado no sistema. Esta classe é mapeada para a
 * tabela <i>tb_supplier</i> no banco de dados.</p>
 *
 * <p>A entidade Supplier possui as seguintes características:</p>
 * <ul>
 *   <li><b>name</b>: Nome do fornecedor. Não pode ser nulo ou vazio.</li>
 *   <li><b>cnpj</b>: CNPJ do fornecedor, sendo único e validado conforme o padrão
 *       brasileiro. Não pode ser nulo ou vazio.</li>
 *   <li><b>email</b>: E-mail de contato do fornecedor. Deve ser único, válido e
 *       não nulo ou vazio.</li>
 *   <li><b>phone</b>: Telefone de contato do fornecedor. Não pode ser nulo ou vazio.</li>
 *   <li><b>address</b>: Endereço associado ao fornecedor. Não pode ser nulo.</li>
 * </ul>
 *
 * <p>As validações para os campos foram implementadas através de anotações do Bean
 * Validation e do Hibernate Validator.</p>
 *
 * <p>Esta classe também implementa os métodos <b>equals</b> e <b>hashCode</b>, que
 * utilizam o campo <i>cnpj</i> como base para comparação de igualdade e cálculo de
 * hash.</p>
 *
 * <p>É significativo para sistemas que gerenciam fornecedores ou operações associadas
 * a estoques e integração com diferentes partes da cadeia de suprimento.</p>
 *
 * <p>As principais anotações e mapeamentos utilizados incluem:</p>
 * <ul>
 *   <li><b>@Entity</b>: Define esta classe como uma entidade JPA.</li>
 *   <li><b>@Table</b>: Especifica o nome da tabela no banco de dados (<i>tb_supplier</i>).</li>
 *   <li><b>@DynamicUpdate</b>: Permite que apenas os campos alterados sejam atualizados no banco de dados.</li>
 *   <li><b>@Id</b>: Define o campo <i>cnpj</i> como a chave primária.</li>
 *   <li><b>@OneToOne</b>: Define um relacionamento um-para-um entre Supplier e Address.</li>
 * </ul>
 *
 * <p><b>Nota:</b> Instâncias de Supplier devem sempre conter valores válidos para
 * todos os campos obrigatórios a fim de garantir a consistência do banco de dados
 * e a integridade dos dados.</p>
 */
@Entity(name = "supplier")
@DynamicUpdate
@Table(name = "tb_supplier")
public class Supplier {

	@NotBlank(message = "The supplier's name cannot be null and void.")
	@Column(name = "supplier_name", nullable = false)
	private String name;

	@Id
	@CNPJ(message = "The supplier's CNPJ is invalid.")
	@NotBlank(message = "The CNPJ of the supplier cannot be null and void.")
	@Column(name = "supplier_cnpj", nullable = false, unique = true, length = 14)
	private String cnpj;

	@Email(message = "The supplier's email is invalid.")
	@NotBlank(message = "The supplier's email cannot be null and void.")
	@Column(name = "supplier_email", nullable = false, unique = true)
	private String email;

	@NotBlank(message = "The supplier's phone cannot be null and void.")
	@Column(name = "supplier_phone", nullable = false)
	private String phone;

	@OneToOne(cascade = CascadeType.ALL)
	@NotNull(message = "The supplier's address cannot be null.")
	@JoinColumn(name = "supplier_address", nullable = false)
	private Address address;

	public Supplier() {
	}

	public Supplier(String name, String cnpj, String email, String phone, Address address) {
		this.name = name;
		this.cnpj = cnpj;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;

		Supplier supplier = (Supplier) o;
		return cnpj.equals(supplier.cnpj);
	}

	@Override
	public int hashCode() {
		return cnpj.hashCode();
	}
}
