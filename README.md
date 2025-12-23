# med.voll.api.java

API REST em Spring Boot para cadastro de médicos, com persistência via JPA, validação e migrações de banco (Flyway). Projeto inspirado no curso da Alura (Voll Med).

## Tecnologias
- Java 21, Spring Boot 4 (web, data JPA, validation, actuator)
- H2 em memória (padrão) e dependência para MySQL/PostgreSQL
- Flyway para migrações (`src/main/resources/db/migration`)
- Lombok

## Como rodar localmente
1. Requisitos: JDK 21 e Maven.
2. Instale dependências e rode:
   ```bash
   ./mvnw spring-boot:run
   ```
3. A aplicação sobe em `http://localhost:8080`.
4. Console H2 disponível em `http://localhost:8080/h2-console` (JDBC: `jdbc:h2:mem:testdb`).

## Banco e migrações
- Migração inicial: `V1__create-table-medico.sql` cria a tabela `medicos` com campos pessoais e de endereço.
- `application.properties` está configurado para H2 em memória (`ddl-auto=update`). Para usar MySQL/PostgreSQL, ajuste `spring.datasource.*` e remova/ajuste `ddl-auto` conforme preferir.

## Endpoint principal
### POST /medicos
Cria um médico.

Payload JSON:
```json
{
  "nome": "Fulano de Tal",
  "email": "fulano@exemplo.com",
  "crm": "123456",
  "especialidade": "CARDIOLOGIA",
  "endereco": {
    "logradouro": "Rua A",
    "bairro": "Centro",
    "cep": "12345678",
    "cidade": "São Paulo",
    "uf": "SP",
    "complemento": "Conj. 101",
    "numero": "100"
  }
}
```

Validações:
- `nome`, `email`, `crm`, `especialidade` e todos os campos obrigatórios de endereço são requeridos.
- `email` precisa ser válido; `crm` precisa ter 4 a 6 dígitos; `cep` deve ter 8 dígitos.

## Estrutura
- `com.vicen.med.voll.api.medico`: controller, entidade, repositório e DTO de cadastro.
- `com.vicen.med.voll.api.endereco` e `med.voll.api.endereco`: value objects/DTO para endereço.
- `src/main/resources/db/migration`: scripts Flyway.

## Testes
```bash
./mvnw test
```