# Controle de Estoques (Maternal)

Este é um projeto de sistema de controle de estoques desenvolvido para facilitar o gerenciamento de produtos, fornecedores, usuários e movimentações de estoque. O foco é proporcionar um ambiente de aprendizado colaborativo para desenvolvedores juniores/estagiários, permitindo a prática de boas práticas de desenvolvimento, versionamento e integração contínua.

---

## Sumário

- [Visão Geral](#visão-geral)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Requisitos](#requisitos)
- [Instalação e Configuração](#instalação-e-configuração)
  - [Back-end](#back-end)
  - [Front-end](#front-end)
- [Endpoints da API](#endpoints-da-api)
- [Divisão de Tasks](#divisão-de-tasks)
- [Contribuição](#contribuição)
- [Licença](#licença)

---

## Visão Geral

O **Controle de Estoques (Maternal)** é uma aplicação web para gerenciar o cadastro de produtos, fornecedores e usuários, controlar o estoque, registrar saídas de produtos e gerar relatórios detalhados. O sistema utiliza exclusão lógica para manter um histórico de produtos removidos e alertas de baixo estoque para facilitar a gestão.

---

## Funcionalidades

- **Cadastro e Manutenção de Produtos**
  - Inclusão, edição e exclusão lógica (registro em *Itens_excluidos*) de produtos.
  - Validações de campos (nome, descrição, preço, quantidade) e verificação de duplicidade.
  - Associação de cada produto a um fornecedor existente.

- **Controle de Estoque**
  - Alerta para produtos com quantidade abaixo do mínimo configurado.
  - Registro de saídas de estoque, com atualização automática da quantidade disponível.

- **Gestão de Fornecedores e Endereços**
  - CRUD de fornecedores com informações como nome, CNPJ, email, telefone e endereço.
  - Validações de formato para CNPJ e email.

- **Autenticação e Controle de Acesso**
  - Registro e login de usuários com utilização de JWT para autenticação.
  - Definição de roles (ex.: ADMIN, VENDEDOR, CLIENTE) para controle de acesso.

- **Relatórios e Exportação**
  - Geração de relatórios de estoque, listando produtos, produtos com baixo estoque e histórico de movimentações.
  - Exportação dos relatórios em formatos CSV e PDF.

---

## Tecnologias Utilizadas

### Back-end
- **Linguagem:** Java
- **Framework:** Spring Boot
- **Persistência:** JPA/Hibernate
- **Banco de Dados:** PostgreSQL
- **Segurança:** Spring Security com JWT
- **Gerenciamento de Dependências:** Maven ou Gradle

### Front-end
- **Linguagem:** JavaScript/TypeScript
- **Framework:** React
- **Ferramentas:** Vite (bundler), Tailwind CSS para estilização, Axios para consumo de API

---

## Requisitos

- **Back-end:**
  - Java 17 ou superior
  - PostgreSQL
  - Maven ou Gradle

- **Front-end:**
  - Node.js (versão LTS)
  - npm ou yarn

---

## Instalação e Configuração

### Back-end

1. **Clone o Repositório:**

   ```bash
   git clone https://github.com/seu-usuario/controle-estoques-maternal.git
   cd controle-estoques-maternal/backend
   ```
2. **Configuração do Banco de Dados:**

- Crie um banco de dados PostgreSQL.
- Atualize o arquivo application.properties (ou application.yml) com as configurações do banco:

```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
Instalação das Dependências e Execução:
```

- Com Maven:
```bash
mvn clean install
mvn spring-boot:run
```
- Ou com Gradle:
```bash
./gradlew build
./gradlew bootRun
```
--------

### **Front-end**

1. **Clone o Repositório (separado ou na mesma pasta):**

```bash
cd controle-estoques-maternal/frontend
```

2. **Instale as Dependências:**

```bash
npm install
```

3. **Inicie a Aplicação:**

```bash
npm run dev
```

A aplicação React iniciará e estará disponível para acesso via navegador.

---

## **Endpoints da API**

### **ProdutoController**
- GET /produtos: Lista todos os produtos.
- POST /produtos: Cria um novo produto.
- PUT /produtos/{id}: Atualiza um produto existente.
- DELETE /produtos/{id}: Registra a exclusão lógica do produto (insere registro em Itens_excluidos e/ou marca como inativo).
- FornecedorController
### **Endpoints para CRUD de fornecedores e gerenciamento dos endereços.**
 #### **Autenticação (Usuário)**
- POST /auth/login: Realiza o login e retorna o token JWT.
- POST /auth/register: Registra um novo usuário.
#### **EstoqueController**
- POST /estoque/saida: Registra a saída de produtos, atualizando o estoque e salvando a operação na tabela Saída_Produtos.
#### **RelatorioController**
- GET /relatorios/estoque: Gera relatórios de estoque com filtros e possibilita a exportação em CSV/PDF.

---
# Divisão de Tasks

Caso queira contribuir com o projeto, entre no [trello](https://trello.com/invite/b/67ca080f5686e4341e568ac8/ATTI790cf9712c82ae57b8926d86c172085538917869/sistema-de-controle-de-estoque) e veja as tasks disponíveis

---

# Licença

Este projeto está licenciado sob a [MIT License](https://choosealicense.com/licenses/mit/).

---
