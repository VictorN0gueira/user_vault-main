# Backend - USER_VALT-MAIN

Este é o backend do sistema, desenvolvido em Java com Spring Boot. Ele fornece uma API RESTful para gerenciar os usuários.

### Portas Configuradas

Frontend (Angular): http://localhost:4200
API do Backend (Java/Spring Boot): http://localhost:3000/api
Porta da API Backend: 3000

## Como Rodar o Backend

### Requisitos:
- **JDK 11 ou superior**
- **Maven** (caso não tenha, instale com `sudo apt-get install maven` ou baixe do [site oficial do Maven](https://maven.apache.org/download.cgi))

### Passos para Rodar o Backend

1. **Clone o Repositório**:
   ```bash
   git clone <URL_DO_REPOSITORIO>
   cd USER_VALT-MAIN

2. **Instale as dependências**:
   ```bash
   mvn clean install

3. **Alterar a Porta do Backend (se necessário): Por padrão, o backend roda na porta 3000. Se você precisar alterar a porta:**:
   ```bash
   server.port=3000

4. **Rodar o Backend: Para rodar o backend, utilize o Maven:**:
   ```bash
   mvn spring-boot:run

# API no Backend
A API RESTful criada no backend está disponível na porta 3000.
Exemplo de endpoint: http://localhost:3000/api/users
Você pode testar a API com ferramentas como Postman ou Insomnia.

   ```bash
   mvn clean install

Endpoints principais:

GET /api/users - Listar usuários
POST /api/users - Criar um novo usuário
PUT /api/users/{id} - Atualizar um usuário existente
DELETE /api/users/{id} - Deletar um usuário


