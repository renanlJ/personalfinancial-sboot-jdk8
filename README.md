# Documentação do Projeto: Gerenciamento Financeiro Pessoal

## Descrição

Este projeto é uma aplicação de gerenciamento financeiro pessoal desenvolvida em Java utilizando o framework Spring Boot. O objetivo é permitir que os usuários registrem seus salários e calculem a distribuição de gastos em diferentes categorias, como custos essenciais, educação, aposentadoria, entre outros.

## Tecnologias Utilizadas

- **Java 8**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **Lombok**
- **Banco de Dados**: H2 (ou outro banco de dados relacional)

## Estrutura do Projeto

A estrutura do projeto é organizada da seguinte forma:

```
src
└── main
    └── java
        └── com
            └── learning
                └── jdk8
                    └── personalfinancial
                        ├── PersonalfinancialApplication.java
                        ├── controller
                        │   └── FinanceController.java
                        ├── domain
                        │   ├── Distribution.java
                        │   └── Salary.java
                        ├── repository
                        │   ├── DistributionRepository.java
                        │   └── SalaryRepository.java
                        └── service
                            └── FinanceService.java
```

## Funcionalidades

- **Registrar Salário**: Permite que os usuários registrem seus salários.
- **Calcular Distribuição**: Calcula a distribuição do salário em diferentes categorias:
  - Custos Essenciais
  - Educação
  - Livre
  - Aposentadoria
  - Metas Futuras
- **Salvar Distribuições**: As distribuições calculadas são salvas no banco de dados.

## Como Executar o Projeto

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu_usuario/personal-financial-management.git
   cd personal-financial-management
   ```

2. **Compile o projeto**:
   Certifique-se de ter o Maven instalado e execute:
   ```bash
   mvn clean install
   ```

3. **Execute a aplicação**:
   ```bash
   mvn spring-boot:run
   ```

4. **Acesse a API**:
   A aplicação estará disponível em `http://localhost:8080/api/finance`.

## Endpoints da API

### 1. Calcular Distribuição

- **Método**: `POST`
- **URL**: `/api/finance/calculate`
- **Corpo da Requisição**:
  ```json
  {
      "amount": 3000.00,
      "paymentDate": "2023-01-15"
  }
  ```

- **Resposta**:
  ```json
  {
      "Essential Costs": 1650.00,
      "Education": 150.00,
      "Free": 300.00,
      "Retirement": 300.00,
      "Future Goals": 600.00
  }
  ```
