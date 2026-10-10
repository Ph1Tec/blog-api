[README.md](https://github.com/user-attachments/files/33292343/README.md)
# Blog API

API REST para um blog simples com usuários, posts e comentários, desenvolvida em Java com Spring Boot. Projeto de estudo com foco em múltiplos relacionamentos entre entidades e persistência em PostgreSQL.

## Tecnologias

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Lombok
- Maven

## Como rodar o projeto

1. Clone o repositório:
```bash
git clone https://github.com/Ph1Tec/blog-api.git
cd blog-api
```

2. Crie o banco de dados no PostgreSQL:
```sql
CREATE DATABASE blogdb;
```

3. Configure a variável de ambiente `DB_PASSWORD` com a senha do seu usuário do PostgreSQL (na IDE, em "Edit Configurations" > "Environment variables", ou no sistema operacional).

4. Rode a aplicação:
```bash
./mvnw spring-boot:run
```

5. A aplicação sobe em `http://localhost:8080`

## Modelo de dados

- Um **Usuário** pode escrever vários **Posts**
- Um **Post** pode ter vários **Comentários**
- Um **Comentário** pertence a um **Post** e a um **Usuário** (o autor do comentário)

Os três relacionamentos são `@ManyToOne`, declarados do lado "muitos".

## Endpoints

### Usuários

Base URL: `http://localhost:8080/users`

| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/users` | Cria um novo usuário |
| GET | `/users` | Lista todos os usuários |
| GET | `/users/{id}` | Busca um usuário pelo id |

**Exemplo de criação:**
```json
{
    "username": "mariasilva",
    "email": "maria@email.com"
}
```

### Posts

Base URL: `http://localhost:8080/posts`

| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/posts` | Cria um novo post |
| GET | `/posts` | Lista todos os posts |
| GET | `/posts/{id}` | Busca um post pelo id |

**Exemplo de criação:**
```json
{
    "title": "Meu primeiro post",
    "content": "Esse é o conteúdo do meu primeiro post no blog.",
    "authorId": 1
}
```

### Comentários

Base URL: `http://localhost:8080/comments`

| Método | Rota | Descrição |
|--------|------|-----------|
| POST | `/comments` | Cria um comentário em um post |
| GET | `/comments/post/{postId}` | Lista os comentários de um post específico |

**Exemplo de criação:**
```json
{
    "content": "Ótimo post!",
    "postId": 1,
    "authorId": 1
}
```

**Exemplo de resposta:**
```json
{
    "id": 1,
    "content": "Ótimo post!",
    "createdAt": "2026-10-10T14:30:00",
    "postId": 1,
    "author": {
        "id": 1,
        "username": "mariasilva",
        "email": "maria@email.com"
    }
}
```

## Tratamento de erros

| Situação | Status HTTP |
|----------|-------------|
| Usuário não encontrado | 404 Not Found |
| Post não encontrado | 404 Not Found |

O erro é tratado em um único lugar (`GlobalExceptionHandler`), inclusive quando acontece dentro da criação de um post ou comentário com `authorId` ou `postId` inexistente.

## Boas práticas aplicadas

- Senha do banco protegida via variável de ambiente (`${DB_PASSWORD}`), nunca exposta no código
- DTOs de entrada: o cliente envia apenas ids (`authorId`, `postId`) em vez de objetos completos
- DTOs de resposta, incluindo DTOs aninhados, evitando serialização circular e repetição de dados (o comentário devolve só o `postId`, não o post inteiro)
- Exceções customizadas + `@RestControllerAdvice` para respostas de erro com o status HTTP correto
- Query method (`findByPostId`) para filtrar comentários por post

## Estrutura do projeto

```
src/main/java/com/blog/blogdb/
 ├── model/         # Entidades JPA (User, Post, Comment)
 ├── dto/           # DTOs de entrada e saída
 ├── repository/    # Interfaces de acesso ao banco
 ├── service/       # Regras de negócio
 ├── controller/    # Endpoints REST
 └── exception/     # Exceções customizadas e tratamento global de erros
```

## Próximos passos

- [ ] Update e Delete para usuários, posts e comentários
- [ ] Validação de campos (título obrigatório, e-mail válido)
- [ ] Autenticação com login e JWT
- [ ] Paginação na listagem de posts
