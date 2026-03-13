📞 Customer Phone Manager

Projeto desenvolvido para estudo de Hexagonal Architecture (Ports and Adapters), aplicando separação entre domínio, casos de uso e infraestrutura utilizando Spring Boot e Spring Data JPA.

A aplicação permite gerenciar clientes e seus telefones, mantendo o domínio isolado da infraestrutura.

🎯 Objetivo do Projeto

O principal objetivo deste projeto é demonstrar na prática conceitos de arquitetura limpa, como:

Separação entre regras de negócio e infraestrutura

Uso de ports e adapters

Independência do domínio em relação ao banco de dados

Facilidade para substituir tecnologias externas

🧱 Arquitetura

O projeto segue o modelo da Arquitetura Hexagonal, onde:

O domínio contém apenas regras de negócio.

A comunicação com o mundo externo acontece através de interfaces (ports).

Implementações concretas ficam em adapters.

Isso permite trocar facilmente:

banco de dados

frameworks

APIs externas

sem alterar a lógica do sistema.

📂 Estrutura do Projeto
src/main/java
 └── telefoneCliente
      ├── domain
      │    ├── model
      │    └── repository
      │
      ├── application
      │    └── usecase
      │
      └── adapters
           ├── in
           │     └── controller
           │
           └── out
                 └── persistence
Responsabilidade das camadas
Camada	Responsabilidade
Domain	Entidades e regras de negócio
Application	Casos de uso da aplicação
Adapters In	Entrada da aplicação (REST Controllers)
Adapters Out	Integração com infraestrutura (JPA, banco)
🧩 Diagrama da Arquitetura
        ┌───────────────────────┐
        │       Controller      │
        │     (Adapter In)      │
        └──────────┬────────────┘
                   │
                   ▼
        ┌───────────────────────┐
        │       Use Cases       │
        │     (Application)     │
        └──────────┬────────────┘
                   │
                   ▼
        ┌───────────────────────┐
        │        Domain         │
        │   Entities / Rules    │
        └──────────┬────────────┘
                   │
                   ▼
        ┌───────────────────────┐
        │    Repository Port    │
        │      (Interface)      │
        └──────────┬────────────┘
                   │
                   ▼
        ┌───────────────────────┐
        │  JPA Repository       │
        │    (Adapter Out)      │
        └───────────────────────┘

O domínio permanece isolado, enquanto detalhes de infraestrutura são implementados nos adapters.

🗄 Banco de Dados

O projeto utiliza H2 Database Engine em memória para desenvolvimento e testes.

Graças à arquitetura adotada, o banco pode ser facilmente substituído por outros como:

PostgreSQL

MySQL

MariaDB

🔄 Substituindo o H2 por outro banco
1️⃣ Adicione a dependência do banco desejado

Exemplo PostgreSQL:

<dependency>
 <groupId>org.postgresql</groupId>
 <artifactId>postgresql</artifactId>
</dependency>
2️⃣ Configure o datasource
spring.datasource.url=jdbc:postgresql://localhost:5432/customerdb
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
3️⃣ Remova o H2 (opcional)

Remova a dependência do pom.xml.

🚀 Tecnologias Utilizadas

Java

Spring Boot

Spring Data JPA

Hibernate

H2 Database Engine

📌 Aprendizados

Durante o desenvolvimento deste projeto foram aplicados conceitos como:

Arquitetura Hexagonal

Separação de responsabilidades

Domain Driven Design (conceitos básicos)

Mapeamento entre domínio e persistência

Uso de ports e adapters

⭐ Projeto desenvolvido para estudo e prática de arquitetura de software.
