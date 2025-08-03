# API de Gestão Bancária

Este projeto é uma API simples de gestão bancária construída com **Spring Boot 3.4.8** e **JDK 21**.

---

## Como executar o projeto

1. Clone o repositório ou baixe o código fonte.

2. No terminal, dentro da raiz do projeto, execute:

```bash
mvn install
```

3. Após a build, execute o JAR gerado:

```bash
java -jar target/api.gestao.bancaria-0.0.1-SNAPSHOT.jar
```

4. A aplicação será iniciada em: http://localhost:8080

5. Acessando o banco de dados H2

   - A aplicação utiliza um banco de dados H2 em memória.
   - Acesse o console H2: http://localhost:8080/h2-console/login.jsp
   
6. Dados de conexão:

   - JDBC URL: jdbc:h2:mem:gestaobancariadb
   - User Name: sa
   - Password: (em branco)