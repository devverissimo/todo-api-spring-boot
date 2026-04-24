# todo-api-spring-boot

API REST de gerenciamento de tarefas (To-do List) desenvolvida com Spring Boot. Projeto criado para praticar os fundamentos de desenvolvimento backend com Java, incluindo CRUD completo, validações, tratamento global de erros e filtros por status.

## Tecnologias

- Java 21
- Spring Boot 3
- Spring Data JPA
- Spring Validation
- H2 Database (banco em memória)
- Maven

## Funcionalidades

- Criar, listar, buscar, atualizar e deletar tarefas
- Validação automática dos dados de entrada
- Tratamento global de erros com respostas padronizadas
- Filtro de tarefas por status (`PENDENTE`, `EM_ANDAMENTO`, `CONCLUIDA`)
- Separação entre entidade e DTO (nunca expõe a entidade diretamente)

## Como executar

### Pré-requisitos

- Java 21 instalado
- Maven instalado (ou usar o Maven Wrapper incluído no projeto)

### Passos

1. Clone o repositório:

```bash
git clone https://github.com/devverissimo/todo-api-spring-boot.git
cd todo-api-spring-boot
```

2. Execute a aplicação:

```bash
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

## Endpoints

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/tasks` | Lista todas as tarefas |
| GET | `/tasks?status=PENDENTE` | Lista tarefas filtradas por status |
| GET | `/tasks/{id}` | Busca uma tarefa pelo id |
| POST | `/tasks` | Cria uma nova tarefa |
| PUT | `/tasks/{id}` | Atualiza uma tarefa existente |
| DELETE | `/tasks/{id}` | Remove uma tarefa |

## Exemplos de uso

### Criar uma tarefa

```http
POST /tasks
Content-Type: application/json

{
  "titulo": "Estudar Spring Boot",
  "descricao": "Fazer o projeto to-do list",
  "prazo": "2027-12-31"
}
```

Resposta (`201 Created`):

```json
{
  "id": 1,
  "titulo": "Estudar Spring Boot",
  "descricao": "Fazer o projeto to-do list",
  "status": "PENDENTE",
  "prazo": "2027-12-31"
}
```

### Listar tarefas por status

```http
GET /tasks?status=PENDENTE
```

### Buscar tarefa por id

```http
GET /tasks/1
```

### Atualizar tarefa

```http
PUT /tasks/1
Content-Type: application/json

{
  "titulo": "Estudar Spring Boot",
  "descricao": "Revisar anotações",
  "prazo": "2027-06-30"
}
```

### Deletar tarefa

```http
DELETE /tasks/1
```

Resposta: `204 No Content`

## Validações

A API valida os dados de entrada automaticamente:

- `titulo` — obrigatório, não pode ser vazio
- `prazo` — deve ser uma data presente ou futura

Erros de validação retornam `400 Bad Request` com detalhes dos campos inválidos.

## Console do banco H2

Durante o desenvolvimento, é possível acessar o banco de dados em memória pelo navegador:

```
http://localhost:8080/h2-console
```

Configurações de acesso:
- **JDBC URL:** `jdbc:h2:mem:testdb`
- **User:** `sa`
- **Password:** *(vazio)*

## Estrutura do projeto

```
src/main/java/com/maria/todo_api/
├── controller/       → endpoints HTTP
├── service/          → regras de negócio
├── repository/       → acesso ao banco
├── model/            → entidade JPA
├── dto/              → objetos de entrada e saída
└── exception/        → exceções e tratamento global de erros
```
