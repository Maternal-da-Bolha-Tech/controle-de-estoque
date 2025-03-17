package com.maternal.controle_estoques.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record ProductDTO(
  @NotBlank(message = "The name of the product should not be null and void.")
  String productName,

  @NotBlank(message = "The description of the product should not be null and void.")
  String productDescription,

  @NotNull(message = "The price of the product should not be null.")
  @Positive(message = "The price of the product must be positive greater than zero.")
  BigDecimal productPrice,

  @NotNull(message = "The quantity of the product should not be null.")
  @PositiveOrZero(message = "The quantity of the product must be greater than or equal to zero.")
  Integer productAmount
) {
}
