# Projeto Back-End Java

Repositório oficial do projeto **Back-End Java**, desenvolvido para gerenciar Aluno Online em um ambiente de servidor com alta escalabilidade e integração. Este projeto segue práticas modernas de desenvolvimento e arquitetura de software.

### 🌟 Funcionalidades

- Operações CRUD completas para gerenciamento de entidades.
- Integração com banco de dados relacional.
- Implementação de camadas distintas para separação de responsabilidades.
- Configuração e testes automatizados para garantir a qualidade do código.



  ### Objetivos por Arquivo/Seção

- **Controller**: Responsável por gerenciar as requisições HTTP e interagir com as camadas de serviço.
- **Service**: Contém a lógica de negócios do sistema.
- **Model**: Representa as entidades do domínio com mapeamento JPA.
- **Repository**: Faz a ponte entre a aplicação e o banco de dados.
- **application.properties**: Configuração para conexão com o banco de dados e propriedades do ambiente.

---

### 📚 Bibliotecas Utilizadas

As seguintes dependências foram configuradas no `pom.xml`:

- **Spring Boot**: Framework principal para simplificar o desenvolvimento Java.
- **Spring Data JPA**: Para integração e manipulação de banco de dados.
- **Lombok**: Redução de boilerplate no código (getters, setters, etc.).
- **Maven**: Gerenciador de dependências.

---

### 🚀 Como Rodar o Projeto

#### Pré-requisitos

- [Java 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) instalado.
- [Maven](https://maven.apache.org/) para gerenciar o projeto.


## 📂 Estrutura de Pastas

```plaintext
ProjetoBeckEndJava/
│
├── src/
│   ├── main/
│   │   ├── java/           
│   │   │   ├── com/projeto/            
│   │   │   │   ├── controller/   # Contém os controladores da aplicação
│   │   │   │   ├── model/        # Define as entidades e modelos de dados
│   │   │   │   ├── repository/   # Gerencia a interface com o banco de dados
│   │   │   │   ├── service/      # Contém as regras de negócio da aplicação
│   │   ├── resources/             
│   │       ├── application.properties  # Configurações de banco e aplicação
│   │
├── test/                         # Testes unitários e de integração
├── pom.xml                       # Gerenciador de dependências Maven
└── README.md                     # Documentação do projeto

