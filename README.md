Desafio 3 - CRUD Completo de Clientes

https://img.shields.io/badge/Java-17-orange?logo=java
https://img.shields.io/badge/Spring%2520Boot-3.x-green?logo=springboot
https://img.shields.io/badge/Maven-3.x-blue?logo=apache-maven
https://img.shields.io/badge/H2-Database-lightgrey?logo=h2
📋 Descrição do Projeto

Sistema completo de CRUD (Create, Read, Update, Delete) para gestão de clientes desenvolvido como parte de um desafio técnico. A aplicação oferece uma API RESTful robusta seguindo as melhores práticas do Spring Boot, com operações básicas de persistência e validação de dados.
✨ Funcionalidades

    📊 Operações CRUD Completas

        Busca paginada de clientes

        Busca de cliente por ID

        Inserção de novo cliente

        Atualização de cliente existente

        Deleção de cliente

    ✅ Validação de Dados

        Validação de nome (não pode ser vazio)

        Validação de data de nascimento (não pode ser data futura)

        Mensagens customizadas para campos inválidos

    ⚡ Tratamento de Exceções

        HTTP 404 para recursos não encontrados

        HTTP 422 para erros de validação

        Respostas padronizadas para erros

    🧪 Ambiente de Testes

        Banco H2 configurado para testes

        Dados de seed com 10 clientes significativos

        Configuração isolada para ambiente de teste

🛠️ Tecnologias Utilizadas

    Backend: Java 23, Spring Boot 3.x

    Build Tool: Maven

    Banco de Dados: H2 (testes)

    Persistence: Spring Data JPA

    Validation: Bean Validation (Jakarta Validation)

    Testing: Spring Boot Test, JUnit 5

📦 Estrutura do Projeto
text

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
│   │   │               ├── dto/           # Objetos de transferência de dados
│   │   │               └── config/        # Configurações da aplicação
│   │   └── resources/
│   │       ├── application.properties     # Configurações principais
│   │       ├── application-test.properties # Configurações específicas para testes
│   │       └── import.sql                   # Dados iniciais (seed)
│   └── test/
│       └── java/
│           └── com/
│               └── desafio3/
│                   └── desafio/
│                       └── controller/     # Testes dos controladores
├── pom.xml                               # Dependências Maven
└── README.md

🚀 Como Executar o Projeto
Pré-requisitos

    Java 23 ou superior

    Maven 3.6 ou superior

    IDE (Eclipse, IntelliJ IDEA, ou VS Code)

Instalação e Execução

    Clone o repositório

bash

git clone https://github.com/marlonmarques/desafio3.git
cd desafio3

    Compile o projeto

bash

mvn clean compile

    Execute a aplicação

bash

mvn spring-boot:run

    Acesse a aplicação

text

Servidor rodando em: http://localhost:8080

Executando os Testes
bash

# Executar todos os testes
mvn test

# Executar testes com relatório de cobertura
mvn test jacoco:report

📡 API Endpoints
Clientes
Método	Endpoint	Descrição
GET	/clients	Busca paginada de clientes
GET	/clients/{id}	Busca cliente por ID
POST	/clients	Cria novo cliente
PUT	/clients/{id}	Atualiza cliente existente
DELETE	/clients/{id}	Remove cliente
Parâmetros de Busca Paginada

    page: Número da página (padrão: 0)

    size: Tamanho da página (padrão: 10)

    sort: Campo para ordenação (ex: name, income)

📊 Modelo de Dados
Entidade Client
java

public class Client {
    private Long id;
    private String name;        // Não pode ser vazio
    private String cpf;
    private Double income;
    private LocalDate birthDate; // Não pode ser data futura
    private Integer children;
}

🧪 Testes com Postman
1. Busca de Cliente por ID
http

GET http://localhost:8080/clients/1

2. Busca Paginada de Clientes
http

GET http://localhost:8080/clients?page=0&size=6&sort=name

3. Inserção de Novo Cliente
http

POST http://localhost:8080/clients
Content-Type: application/json

{
    "name": "Maria Silva",
    "cpf": "12345678901",
    "income": 6500.0,
    "birthDate": "1994-07-20",
    "children": 2
}

4. Atualização de Cliente
http

PUT http://localhost:8080/clients/1
Content-Type: application/json

{
    "name": "Maria Silvaaa",
    "cpf": "12345678901",
    "income": 6500.0,
    "birthDate": "1994-07-20",
    "children": 2
}

5. Deleção de Cliente
http

DELETE http://localhost:8080/clients/1

✅ Checklist de Funcionalidades

    Busca por id retorna cliente existente

    Busca por id retorna 404 para cliente inexistente

    Busca paginada retorna listagem paginada corretamente

    Inserção de cliente insere cliente com dados válidos

    Inserção de cliente retorna 422 e mensagens customizadas com dados inválidos

    Atualização de cliente atualiza cliente com dados válidos

    Atualização de cliente retorna 404 para cliente inexistente

    Atualização de cliente retorna 422 e mensagens customizadas com dados inválidos

    Deleção de cliente deleta cliente existente

    Deleção de cliente retorna 404 para cliente inexistente

🔧 Configuração
application.properties
properties

# Configuração do H2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA Configuration
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

Acessando o Console H2

Durante a execução, acesse: http://localhost:8080/h2-console

    JDBC URL: jdbc:h2:mem:testdb

    User Name: sa

    Password: (vazio)

📝 Dados Iniciais (Seed)

O projeto inclui 10 clientes com dados significativos pré-cadastrados para demonstração e testes.
🤝 Contribuição

    Faça o fork do projeto

    Crie uma branch para sua feature (git checkout -b feature/NovaFeature)

    Commit suas mudanças (git commit -m 'Adiciona NovaFeature')

    Push para a branch (git push origin feature/NovaFeature)

    Abra um Pull Request

📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

Desenvolvido por Marlon Marques
https://img.shields.io/badge/LinkedIn-Marlon%2520Marques-blue?logo=linkedin
https://img.shields.io/badge/GitHub-marlonmarques-black?logo=github