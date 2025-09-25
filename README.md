# Desafio 3 - CRUD Completo de Clientes

![Java](https://img.shields.io/badge/Java-17-orange?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green?logo=springboot)
![Maven](https://img.shields.io/badge/Maven-3.x-blue?logo=apache-maven)
![H2 Database](https://img.shields.io/badge/H2-Database-lightgrey?logo=h2)

---

## 📋 Descrição do Projeto

Sistema completo de CRUD (**Create, Read, Update, Delete**) para gestão de clientes, desenvolvido como parte de um desafio técnico. A aplicação oferece uma API RESTful robusta utilizando **Spring Boot**, seguindo boas práticas de arquitetura, validação de dados e tratamento de exceções.

---

## ✨ Funcionalidades

### 📊 Operações CRUD Completas
- Busca paginada de clientes  
- Busca de cliente por ID  
- Inserção de novo cliente  
- Atualização de cliente existente  
- Exclusão de cliente  

### ✅ Validação de Dados
- Nome não pode ser vazio  
- Data de nascimento não pode ser futura  
- Mensagens personalizadas para campos inválidos  

### ⚡ Tratamento de Exceções
- `HTTP 404` para recursos não encontrados  
- `HTTP 422` para erros de validação  
- Respostas padronizadas em JSON para erros  

### 🧪 Ambiente de Testes
- Banco de dados **H2 em memória** para testes  
- Dados iniciais (*seed*) com 17 clientes significativos  
- Configuração isolada (`application-test.properties`)  

---

## 🛠️ Tecnologias Utilizadas

| Camada       | Tecnologia                     |
|-------------|--------------------------------|
| Backend     | Java 23, Spring Boot 3.x       |
| Build Tool  | Maven                          |
| Banco       | H2 (em memória, para testes)   |
| Persistência| Spring Data JPA                |
| Validação   | Jakarta Bean Validation        |
| Testes      | Spring Boot Test, JUnit 5      |

---

## 📦 Estrutura do Projeto
<pre>
```
desafio3/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── desafio3/
│   │   │           └── desafio/
│   │   │               ├── controller/     # Controladores REST
│   │   │               ├── entity/         # Entidades JPA
│   │   │               ├── repository/     # Repositórios Spring Data
│   │   │               ├── service/        # Lógica de negócio
│   │   │               ├── dto/            # Objetos de transferência (DTOs)
│   │   │               └── config/         # Configurações da aplicação
│   │   └── resources/
│   │       ├── application.properties          # Configurações principais
│   │       ├── application-test.properties     # Config para testes
│   │       └── import.sql                      # Dados iniciais (seed)
│   └── test/
│       └── java/
│           └── com/
│               └── desafio3/
│                   └── desafio/
│                       └── controller/         # Testes dos controladores
├── pom.xml                           # Dependências Maven
└── README.md

---
```
</pre>

## 🚀 Como Executar o Projeto

### Pré-requisitos
- Java 23 ou superior
- Maven 3.6 ou superior
- IDE (IntelliJ, Eclipse ou VS Code)

### Instalação e Execução

```bash
# 1. Clonar o repositório
git clone https://github.com/marlonmarques/desafio3.git
cd desafio3

# 2. Compilar o projeto
mvn clean compile

# 3. Executar a aplicação
mvn spring-boot:run

Servidor rodando em: http://localhost:8080

# Executar todos os testes
mvn test

# Gerar relatório de cobertura com JaCoCo
mvn test jacoco:report
---
```
## 📡 API Endpoints

| Método  | Endpoint | Descrição |
|---------|----------|-----------|
| GET     | /clients | Busca paginada de clientes |
| GET	  | /clients/{id} |	Busca cliente por ID |
| POST	  | /clients |	Cria novo cliente |
| PUT	  | /clients/{id} |	Atualiza cliente existente |
| DELETE  | /clients/{id} |	Remove cliente |
| ------------- | ------------- | ------------- |

## Parâmetros de Busca Paginada 

    page: número da página (padrão: 0)
    size: tamanho da página (padrão: 10)
    sort: campo para ordenação (ex: name, income)

## 📊 Modelo de Dados: Entidade Client

```java
public class Client {
    private Long id;
    private String name;        // Não pode ser vazio
    private String cpf;
    private Double income;
    private LocalDate birthDate; // Não pode ser data futura
    private Integer children;
}
```

## 🧪 Testes com Postman 
### 🔍 Busca de Cliente por ID 
```http
GET http://localhost:8080/clients/1
```
### 📄 Busca Paginada de Clientes
```http
GET http://localhost:8080/clients?page=0&size=6&sort=name
```
### ➕ Inserção de Novo Cliente
```http
POST http://localhost:8080/clients
Content-Type: application/json

{
  "name": "Maria Silva",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20",
  "children": 2
}
```
### ✏️ Atualização de Cliente Existente
```http
PUT http://localhost:8080/clients/1
Content-Type: application/json

{
  "name": "Maria Silva",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20",
  "children": 2
}
```
### 🗑️ Exclusão de Cliente
```http
DELETE http://localhost:8080/clients/1
```
## ✅ Checklist de Funcionalidades
```
* Busca por ID retorna cliente existente  
* Busca por ID retorna 404 se não encontrado  
* Busca paginada retorna lista correta  
* Inserção com dados válidos cria cliente  
* Inserção com dados inválidos retorna 422 + mensagens  
* Atualização com dados válidos atualiza cliente  
* Atualização de cliente inexistente retorna 404  
* Atualização com dados inválidos retorna 422  
* Deleção remove cliente existente  
* Deleção de cliente inexistente retorna 404
---###
```
## 🔧 Configuração Principal (application.properties)

```properties
# Configuração do H2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA Configuration
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true

# Console H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```
### Acessando o Console H2
```
Durante a execução, acesse: http://localhost:8080/h2-console  

    * JDBC URL: jdbc:h2:mem:testdb  
    * User Name: sa  
    * Password: (vazio)
```
## 📝 Dados Iniciais (Seed)

O projeto inclui 17 clientes pré-cadastrados com dados realistas para facilitar demonstrações e testes. Os dados são carregados automaticamente via import.sql.

## 🤝 Contribuição
  1. Faça um fork do projeto  
  2. Crie uma branch: git checkout -b feature/minha-feature  
  3. Commit suas mudanças: git commit -m 'Adiciona nova funcionalidade'  
  4. Push: git push origin feature/minha-feature  
  5. Abra um Pull Request

## 📄 Licença
Este projeto está licenciado sob a MIT License. Veja o arquivo LICENSE  para detalhes.

## 📬 Desenvolvido por Marlon Marques

![Linkedin](https://linkedin.com/in/marlonmarques?spm=a2ty_o01.29997173.0.0.4fe7c921qt0Boo)
![Github](https://github.com/marlonmarques)
     