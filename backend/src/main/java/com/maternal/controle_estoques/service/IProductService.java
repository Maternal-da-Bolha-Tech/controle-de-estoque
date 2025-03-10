package com.maternal.controle_estoques.service;

import com.maternal.controle_estoques.dto.ProductDTO;

/**
 * Interface de serviço para gerenciar operações de {@code Product} no sistema de inventário.
 * Esta interface fornece métodos para interagir e gerenciar a lógica de negócios relacionada ao inventário.
 * <p>
 * As responsabilidades primárias incluem:
 * - Adicionar novos produtos ao inventário.
 * <p>
 * Resumo do Método:
 * - {@code insertNewProduct(ProductDTO newProduct)}: Persiste uma nova entidade de produto no sistema de inventário.
 * <p>
 * As implementações desta interface devem lidar com a lógica de validação de dados, mapeamento e interação com
 * camadas de repositório ou outros serviços necessários para gerenciar os dados do produto de forma eficaz.
 */
public interface IProductService {
  ProductDTO insertNewProduct(ProductDTO newProduct);
}
