# Projeto MaisPraTi e Codifica: Projeto Final - JobsRocket
A JobsRocket é um projeto desenvolvido como parte do curso de Desenvolvimento Full Stack Jr., oferecido pela parceria entre [+praTI](https://www.maisprati.com.br/) e [Codifica](https://www.codificaedu.com.br/).   
Nesse projeto foi desenvolvido o Front-End em React e o Back-end em Java.

## :paperclips: Requisitos do Projeto

Desenvolver um backend robusto e escalável, utilizando Spring Boot e MySQL, que ofereça suporte às funcionalidades da aplicação front-end, garantindo segurança, performance e integração eficiente com OAuth2, gerenciamento de perfis, e interações avançadas.

## :paperclips: Requisitos Funcionais
 Autenticação de Usuário  
- Spring Security: Usar Spring Security com suporte a OAuth2 para integração com Google e Facebook.
- JWT: Após a autenticação via OAuth2, emitir um JSON Web Token (JWT) para manter o usuário autenticado durante a sessão.
- Recuperação de Senha: Implementar um fluxo de recuperação de senha com envio de e-mail utilizando Spring Mail, permitindo o reset de senha via link expiratório.

Gerenciamento de Perfis com Preferências
- Criar uma entidade UserProfile para armazenar informações pessoais e preferências, como tema (escuro/claro) e notificações.
- Implementar endpoints RESTful para permitir que o usuário edite suas preferências e informações de perfil

Lista de Itens com Paginação e Carregamento Infinito
- Implementar paginação utilizando Spring Data JPA com consultas paginadas ao MySQL.
- Para o carregamento infinito, criar endpoints que suportem cursor-based pagination para retornar um fluxo contínuo de itens à medida que o usuário rola a página.

Detalhes do Item com Comentários e Avaliações
- Criar entidades como Item, Comment, e Rating para lidar com os detalhes dos itens, avaliações e comentários.
- Utilizar o Spring Data JPA para realizar operações CRUD com as entidades e agregação de médias de avaliações.
- Implementar endpoints para listar, adicionar e modificar comentários e avaliações com validação no servidor.

Pesquisa com Filtros Avançados
- Implementar um sistema de busca com filtros avançados usando Specification API do Spring Data JPA.
- Implementar filtros baseados em preço, categorias e outras opções dinâmicas.
- Para sugestões de busca baseadas no histórico do usuário, armazenar o histórico de pesquisas em uma entidade separada (SearchHistory) e usar consultas customizadas em MySQL.

## :paperclips: Requisitos Não Funcionais:
Performance e Otimização
- Utilizar Hibernate Query Cache e Spring Cache para cachear consultas frequentes.
- Implementar lazy loading nas associações entre entidades para evitar carregar dados desnecessários.
- Usar DTOs (Data Transfer Objects) para otimizar a transferência de dados entre o backend e o front-end, evitando enviar grandes volumes de dados irrelevantes.
- Otimizar o uso de índices no MySQL para garantir que as consultas sejam executadas de forma eficiente.

Segurança
- Configurar Spring Security com JWT para autenticação e proteção das APIs.
- Implementar autenticação de dois fatores (2FA) usando Spring Security com envio de OTP (One Time Password) via e-mail ou SMS.
- Proteção contra ataques comuns:
  - SQL Injection: Usar Prepared Statements com o Spring Data JPA.
  - XSS (Cross-Site Scripting) e CSRF: Implementar proteções via Spring Security.
  - Configurar HTTPS e headers de segurança adequados (como Content-Security-Policy).

Escalabilidade e Manutenção
- Adotar uma arquitetura modular no Spring Boot, dividindo o backend em diferentes módulos, como user-service, auth-service, item-service, etc.
- Implementar CI/CD com Jenkins ou GitHub Actions, com integração contínua para testes e deploy.
- Garantir que o código siga as boas práticas de desenvolvimento (DRY, SOLID), com uma estrutura modular e reutilizável.

## :pushpin: Projeto JobsRocket

É uma APIRest com as funcionalidades Basicas de CRUD (CREATE, READ, UPDATE AND DELETE) com seus devidos endpoints para um site de busca de emprego. Além disso, contém exceções customizadas, testes unitários, pipeline CI/CD e documentação com Swagger.

### :pushpin: Funcionalidades

- Cadastro, leitura, atualização e exclusão de Currículo.
- Cadastro, leitura, atualização e exclusão de Usuário (Candidato/Recrutador).
- Validação de Email e senha.

## :man_technologist: Conhecimentos aplicados
- **Linguagem de Programação:** Java 17
- **Framework:** Spring Boot 3.3.4
- **Banco de Dados:** PostegreSQL 16.4 (Tembo)
- **Módulos utilizadas:** JUnit, spring security, spring JPA, spring Web, lombok, validation
- **Arquitetura:** O projeto segue os princípios de SOLID e adota o padrão de arquitetura MVC (Model-View-Controller).
- **Metodologia de Desenvolvimento:** Scrum
- **Gerenciamento do Projeto:** [Jira](https://lizianecysne.atlassian.net/jira/software/projects/JB/boards/3/backlog)
- **CI/CD:** Github Actions

## ⚙️ Como Executar
1. Clone o repositório em uma pasta de preferência
  ```
  https://github.com/MissãoVagas/back_end_JobsRocket.git
  ```
2. Entre na pasta que você acabou de clonar e instale as dependências
  ```
  mvn install
  ```
3. Visualize a interface da API utilizando o Thunder Client, Postman, Insomnia ou outra plataforma de sua preferência <br>
> **Acesso ao Swagger UI (Opcional)** <br>
   Se preferir, você pode explorar e testar os endpoints da API acessando o Swagger UI. <br>
   Certifique-se de que o projeto esteja em execução e acesse a URL abaixo pelo seu navegador: <br>
   http://localhost:8080/swagger-ui/index.html#/


## 📚 Documentação (endpoints)
### Observações

Abaixo seguem exemplos que podem ser inseridos em cada endpoint para testar a aplicação. 

## Testando o User (Candidato/Recrutador):
<details>
<summary> Cadastro Candidato (POST) </summary>
    <br>

  | Método | Funcionalidade | URL |
  |---|---|---|
  | `POST` | Realiza o cadastro do candidato no sistema | `http://localhost:8080/api/user/candidato`    
  
  **Request Body**
```json
{
  "nome": "Julia Andrade",
  "email": "julia@teste.com",
  "role": "CANDIDATO",
  "senha": "Teste@123",
  "campoDeInteresse": "Tecnologia"
}

```
**Response**    
```json
{
  "user_id":1,
  "nome": "Julia Andrade",
  "email": "julia@teste.com",
  "role": "CANDIDATO",
  "campoDeInteresse": "Tecnologia"
}
```
**HTTP status:** 201 CREATED or 400 BAD REQUEST   
</details>
<details>
<summary> Cadastro Recrutador (POST) </summary>
    <br>

  | Método | Funcionalidade | URL |
  |---|---|---|
  | `POST` | Realiza o cadastro do recrutador no sistema | `http://localhost:8080/api/user/recrutador`    
  
  **Request Body**
```json
{
  "nome": "Julia Andrade",
  "email": "julia@teste.com",
  "role": "RECRUTADOR",
  "senha": "Teste@123",
  "empresa": "Carros S&A"
}

```
**Response**    
```json
{
  "user_id":1,
  "nome": "Julia Andrade",
  "email": "julia@teste.com",
  "role": "RECRUTADOR",
  "empresa": "Carros S&A"
}
```
**HTTP status:** 201 CREATED or 400 BAD REQUEST
</details>
<details>
<summary> Listar Usuários (GET) </summary>
    <br>

  | Método | Funcionalidade | URL |
  |---|---|---|
  | `GET` | Realiza a busca por todos usuários cadastrados no sistema | `http://localhost:8080/api/user`    
  
**Response**    
```json
[
  {
    "user_id":1,
    "nome": "Julia Andrade",
    "email": "julia@teste.com",
    "role": "RECRUTADOR"
  },
]
```
**HTTP status:** 200 OK
</details>
<details>
<summary> Atualizar Candidato (PUT) </summary>
    <br>

  | Método | Funcionalidade | URL |
  |---|---|---|
  | `PUT` | Realizar a atualização do candidato no sistema | `http://localhost:8080/api/user/candidato/{candidato_id}`    
  
  **Request Body**
```json
{
  "nome": "Julia Andrade",
  "email": "julia@teste.com",
  "role": "RECRUTADOR",
  "senha": "Teste@123",
  "campoDeInteresse": "Tecnologia"
}

```
**Response**    
```json
{
  "user_id":1,
  "nome": "Julia Andrade",
  "email": "julia@teste.com",
  "role": "RECRUTADOR",
  "campoDeInteresse": "Tecnologia"
}
```
**HTTP status:** 200 OK or 400 BAD REQUEST or 404 NOT FOUND
</details>
<details>
<summary> Atualizar Recrutador (PUT) </summary>
    <br>

  | Método | Funcionalidade | URL |
  |---|---|---|
  | `PUT` | Realizar a atualização do recrutador no sistema | `http://localhost:8080/api/user/recrutador/{recrutador_id}`    
  
  **Request Body**
```json
{
  "nome": "Julia Andrade",
  "email": "julia@teste.com",
  "role": "RECRUTADOR",
  "senha": "Teste@123",
  "empresa": "Carros S&A"
}

```
**Response**    
```json
{
  "user_id":1,
  "nome": "Julia Andrade",
  "email": "julia@teste.com",
  "role": "RECRUTADOR",
  "empresa": "Carros S&A"
}
```
**HTTP status:** 200 OK or 400 BAD REQUEST or 404 NOT FOUND
</details>
<details>
<summary> Deletar Usuário (DELETE) </summary>
    <br>

  | Método | Funcionalidade | URL |
  |---|---|---|
  | `DELETE` | Realizar a deleção de um usuário no sistema | `http://localhost:8080/api/user/{user_id}`    

**HTTP status:** 200 OK or 404 NOT FOUND
</details>
<details>
<summary> Buscar Usuário pelo ID (GET) </summary>
    <br>

  | Método | Funcionalidade | URL |
  |---|---|---|
  | `GET` | Realizar a busca de um usuário no sistema pelo id | `http://localhost:8080/api/user/id/{user_id}`    
  
**Response**    
```json
{
  "user_id":1,
  "nome": "Julia Andrade",
  "email": "julia@teste.com",
  "role": "RECRUTADOR"
}
```
**HTTP status:** 200 OK or 404 NOT FOUND
</details>
<details>
<summary> Buscar Usuário pelo Email (GET) </summary>
    <br>

  | Método | Funcionalidade | URL |
  |---|---|---|
  | `GET` | Realizar a busca de um usuário no sistema pelo email | `http://localhost:8080/api/user/email/{email}`    
  
**Response**    
```json
{
  "user_id":1,
  "nome": "Julia Andrade",
  "email": "julia@teste.com",
  "role": "RECRUTADOR"
}
```
**HTTP status:** 200 OK or 404 NOT FOUND
</details>

## Testando o Currículo:
<details>
<summary> Cadastro (POST) </summary>
    <br>

  | Método | Funcionalidade | URL |
  |---|---|---|
  | `POST` | Realiza o cadastro do curriculo no sistema | `http://localhost:8080/api/curriculo/candidato/{candidato_id}`    
  
  **Request Body**
```json
{
  
  "principais": {
    "username": "string",
    "sobre": "string",
    "foto": "string"
  },
  "pessoais": {
    "dataNascimento": "2024-11-19T17:08:45.280Z",
    "pais": "string",
    "cep": "string",
    "estado": "string",
    "cidade": "string",
    "endereco": "string",
    "linkedin": "string",
    "github": "string",
    "portfolioUrl": "string"
  },
  "academicos": [
    {
      "nomeFaculdade": "string",
      "nomeCurso": "string",
      "dataInicio": "2024-11-19T17:08:45.280Z",
      "dataFinal": "2024-11-19T17:08:45.280Z",
      "statusFaculdade": "EM_ANDAMENTO",
      "tipoCurso": "GRADUACAO",
      "tipoFormacao": "BACHARELADO",
      "atividadesExtras": "string"
    }
  ],
  "profissionais": [
    {
      "nomeEmpresa": "string",
      "cargo": "string",
      "dataInicio": "2024-11-19T17:08:45.280Z",
      "dataFinal": "2024-11-19T17:08:45.280Z",
      "tipoEmprego": "TEMPO_INTEGRAL",
      "responsabilidades": "string"
    }
  ],
  "cursos": [
    {
      "nomeCurso": "string",
      "instituicao": "string",
      "duracao": "string",
      "descricao": "string"
    }
  ]
}

```
**Response**    
```json
{
  "curriculo_id": 0,
  "candidato_id": 0,
  "principais": {
    "principais_id": 0,
    "username": "string",
    "sobre": "string",
    "foto": "string"
  },
  "pessoais": {
    "pessoais_id": 0,
    "dataNascimento": "2024-11-19T17:08:45.286Z",
    "pais": "string",
    "cep": "string",
    "estado": "string",
    "cidade": "string",
    "endereco": "string",
    "linkedin": "string",
    "github": "string",
    "portfolioUrl": "string"
  },
  "academicos": [
    {
      "id": 0,
      "nomeFaculdade": "string",
      "nomeCurso": "string",
      "dataInicio": "2024-11-19T17:08:45.286Z",
      "dataFinal": "2024-11-19T17:08:45.286Z",
      "statusFaculdade": "EM_ANDAMENTO",
      "tipoCurso": "GRADUACAO",
      "tipoFormacao": "BACHARELADO",
      "atividadesExtras": "string"
    }
  ],
  "profissionais": [
    {
      "id": 0,
      "nomeEmpresa": "string",
      "cargo": "string",
      "dataInicio": "2024-11-19T17:08:45.286Z",
      "dataFinal": "2024-11-19T17:08:45.286Z",
      "tipoEmprego": "TEMPO_INTEGRAL",
      "responsabilidades": "string"
    }
  ],
  "cursos": [
    {
      "id": 0,
      "nomeCurso": "string",
      "instituicao": "string",
      "duracao": "string",
      "descricao": "string"
    }
  ]
}
```
**HTTP status:** 201 CREATED or 400 BAD REQUEST 
</details>
<details>
<summary> Atualizar (PUT) </summary>
    <br>

  | Método | Funcionalidade | URL |
  |---|---|---|
  | `PUT` | Realiza a atualização do curriculo no sistema | `http://localhost:8080/api/curriculo/{curriculo_id}`    
  
  **Request Body**
```json
{
  
  "principais": {
    "username": "string",
    "sobre": "string",
    "foto": "string"
  },
  "pessoais": {
    "dataNascimento": "2024-11-19T17:08:45.280Z",
    "pais": "string",
    "cep": "string",
    "estado": "string",
    "cidade": "string",
    "endereco": "string",
    "linkedin": "string",
    "github": "string",
    "portfolioUrl": "string"
  },
  "academicos": [
    {
      "nomeFaculdade": "string",
      "nomeCurso": "string",
      "dataInicio": "2024-11-19T17:08:45.280Z",
      "dataFinal": "2024-11-19T17:08:45.280Z",
      "statusFaculdade": "EM_ANDAMENTO",
      "tipoCurso": "GRADUACAO",
      "tipoFormacao": "BACHARELADO",
      "atividadesExtras": "string"
    }
  ],
  "profissionais": [
    {
      "nomeEmpresa": "string",
      "cargo": "string",
      "dataInicio": "2024-11-19T17:08:45.280Z",
      "dataFinal": "2024-11-19T17:08:45.280Z",
      "tipoEmprego": "TEMPO_INTEGRAL",
      "responsabilidades": "string"
    }
  ],
  "cursos": [
    {
      "nomeCurso": "string",
      "instituicao": "string",
      "duracao": "string",
      "descricao": "string"
    }
  ]
}

```
**Response**    
```json
{
  "curriculo_id": 0,
  "candidato_id": 0,
  "principais": {
    "principais_id": 0,
    "username": "string",
    "sobre": "string",
    "foto": "string"
  },
  "pessoais": {
    "pessoais_id": 0,
    "dataNascimento": "2024-11-19T17:08:45.286Z",
    "pais": "string",
    "cep": "string",
    "estado": "string",
    "cidade": "string",
    "endereco": "string",
    "linkedin": "string",
    "github": "string",
    "portfolioUrl": "string"
  },
  "academicos": [
    {
      "id": 0,
      "nomeFaculdade": "string",
      "nomeCurso": "string",
      "dataInicio": "2024-11-19T17:08:45.286Z",
      "dataFinal": "2024-11-19T17:08:45.286Z",
      "statusFaculdade": "EM_ANDAMENTO",
      "tipoCurso": "GRADUACAO",
      "tipoFormacao": "BACHARELADO",
      "atividadesExtras": "string"
    }
  ],
  "profissionais": [
    {
      "id": 0,
      "nomeEmpresa": "string",
      "cargo": "string",
      "dataInicio": "2024-11-19T17:08:45.286Z",
      "dataFinal": "2024-11-19T17:08:45.286Z",
      "tipoEmprego": "TEMPO_INTEGRAL",
      "responsabilidades": "string"
    }
  ],
  "cursos": [
    {
      "id": 0,
      "nomeCurso": "string",
      "instituicao": "string",
      "duracao": "string",
      "descricao": "string"
    }
  ]
}
```
**HTTP status:** 200 OK or 400 BAD REQUEST or 404 NOT FOUND
</details>
<details>
<summary> Listar (GET) </summary>
    <br>

  | Método | Funcionalidade | URL |
  |---|---|---|
  | `GET` | Realiza a busca do curriculo no sistema | `http://localhost:8080/api/curriculo`    
 
**Response**    
```json
[
  {
    "curriculo_id": 0,
    "candidato_id": 0,
    "principais": {
      "principais_id": 0,
      "username": "string",
      "sobre": "string",
      "foto": "string"
    },
    "pessoais": {
      "pessoais_id": 0,
      "dataNascimento": "2024-11-19T17:08:45.286Z",
      "pais": "string",
      "cep": "string",
      "estado": "string",
      "cidade": "string",
      "endereco": "string",
      "linkedin": "string",
      "github": "string",
      "portfolioUrl": "string"
    },
    "academicos": [
      {
        "id": 0,
        "nomeFaculdade": "string",
        "nomeCurso": "string",
        "dataInicio": "2024-11-19T17:08:45.286Z",
        "dataFinal": "2024-11-19T17:08:45.286Z",
        "statusFaculdade": "EM_ANDAMENTO",
        "tipoCurso": "GRADUACAO",
        "tipoFormacao": "BACHARELADO",
        "atividadesExtras": "string"
      }
    ],
    "profissionais": [
      {
        "id": 0,
        "nomeEmpresa": "string",
        "cargo": "string",
        "dataInicio": "2024-11-19T17:08:45.286Z",
        "dataFinal": "2024-11-19T17:08:45.286Z",
        "tipoEmprego": "TEMPO_INTEGRAL",
        "responsabilidades": "string"
      }
    ],
    "cursos": [
      {
        "id": 0,
        "nomeCurso": "string",
        "instituicao": "string",
        "duracao": "string",
        "descricao": "string"
      }
    ]
  },
]
```
**HTTP status:** 200 OK or 400 BAD REQUEST 
</details>

<details>
<summary> Buscar por ID (GET) </summary>
    <br>

  | Método | Funcionalidade | URL |
  |---|---|---|
  | `GET` | Realiza a busca do curriculo no sistema pelo id | `http://localhost:8080/api/curriculo/{curriculo_id}`    
 
**Response**    
```json

  {
    "curriculo_id": 0,
    "candidato_id": 0,
    "principais": {
      "principais_id": 0,
      "username": "string",
      "sobre": "string",
      "foto": "string"
    },
    "pessoais": {
      "pessoais_id": 0,
      "dataNascimento": "2024-11-19T17:08:45.286Z",
      "pais": "string",
      "cep": "string",
      "estado": "string",
      "cidade": "string",
      "endereco": "string",
      "linkedin": "string",
      "github": "string",
      "portfolioUrl": "string"
    },
    "academicos": [
      {
        "id": 0,
        "nomeFaculdade": "string",
        "nomeCurso": "string",
        "dataInicio": "2024-11-19T17:08:45.286Z",
        "dataFinal": "2024-11-19T17:08:45.286Z",
        "statusFaculdade": "EM_ANDAMENTO",
        "tipoCurso": "GRADUACAO",
        "tipoFormacao": "BACHARELADO",
        "atividadesExtras": "string"
      }
    ],
    "profissionais": [
      {
        "id": 0,
        "nomeEmpresa": "string",
        "cargo": "string",
        "dataInicio": "2024-11-19T17:08:45.286Z",
        "dataFinal": "2024-11-19T17:08:45.286Z",
        "tipoEmprego": "TEMPO_INTEGRAL",
        "responsabilidades": "string"
      }
    ],
    "cursos": [
      {
        "id": 0,
        "nomeCurso": "string",
        "instituicao": "string",
        "duracao": "string",
        "descricao": "string"
      }
    ]
  }

```
**HTTP status:** 200 OK or 400 BAD REQUEST or 404 NOT FOUND
</details>

<details>
<summary> Deletar (DELETE) </summary>
    <br>

  | Método | Funcionalidade | URL |
  |---|---|---|
  | `DELETE` | Realiza a deleção do curriculo no sistema | `http://localhost:8080/api/curriculo/{curriculo_id}`    

**HTTP status:** 200 OK or 400 BAD REQUEST 
</details>














