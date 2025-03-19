package com.maternal.controle_estoques.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_product")
public class Product {

	@Id
	@NotBlank(message = "The name of the product should not be null and void.")
	@Column(name = "product_name")
	private String productName;

	@NotBlank(message = "The description of the product should not be null and void.")
	@Column(name = "product_description", nullable = false)
	private String productDescription;

	@NotNull(message = "The price of the product should not be null.")
	@Positive(message = "The price of the product must be positive greater than zero.")
	@Column(name = "product_price", nullable = false, precision = 10, scale = 2)
	private BigDecimal productPrice;

	@NotNull(message = "The quantity of the product should not be null.")
	@PositiveOrZero(message = "The quantity of the product must be greater than or equal to zero.")
	@Column(name = "product_amount", nullable = false)
	private Integer productAmount;

	private Product() {
	}

	public Product(String productName, String productDescription, BigDecimal productPrice, Integer productAmount) {
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productAmount = productAmount;
	}

	public String getProductName() {
		return productName;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	private void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductAmount() {
		return productAmount;
	}

	private void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	private void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	private void setProductAmount(Integer productAmount) {
		this.productAmount = productAmount;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;

		Product product = (Product) o;
		return productName.equals(product.productName);
	}

	@Override
	public int hashCode() {
		return productName.hashCode();
	}
}
