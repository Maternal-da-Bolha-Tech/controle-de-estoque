package com.maternal.controle_estoques.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

/**
 * Representa um objeto de transferência de dados (DTO) para um produto no sistema,
 * carregando as informações necessárias sobre o produto entre as camadas da aplicação.
 * <p>
 * Este registro encapsula os seguintes campos com suas validações específicas:
 * <p>
 * - {@code productName}: O nome do produto, que não deve ser nulo ou vazio.
 * <p>
 * - {@code productDescription}: Uma breve descrição do produto, que não deve ser nula ou vazia.
 * <p>
 * - {@code productPrice}: O preço do produto, que deve ser um valor positivo maior que zero e não nulo.
 * <p>
 * - {@code productAmount}: A quantidade disponível do produto, que deve ser um valor não negativo e não nulo.
 * <p>
 * O objetivo deste DTO é garantir a representação consistente das informações do produto
 * enquanto aplica regras de validação para manter a integridade dos dados.
 */
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
