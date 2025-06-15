🔐 Autenticação com JWT
📌 Registro de Usuário
POST /auth/register
Cria um novo usuário.

json
Copiar
Editar
Request Body:
{
  "login": "admin",
  "password": "123",
  "role": "USER"
}
🔑 Login
POST /auth/login
Retorna um token JWT para autenticação.

json
Copiar
Editar
Request Body:
{
  "login": "admin",
  "password": "123"
}
🛡️ Use o token JWT retornado no cabeçalho das requisições protegidas:

makefile
Copiar
Editar
Authorization: Bearer <token_gerado>
🔒 Endpoints Protegidos
Todos os endpoints abaixo exigem autenticação via token JWT no header Authorization.

🔁 Exemplo de uso do token no header:
makefile
Copiar
Editar
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
✏️ Editar Usuário (somente ADMIN)
PUT /pessoa/editarPessoa/{id}
Edita os dados de qualquer usuário.

json
Copiar
Editar
Request Body:
{
  "password": "admin2",
  "login": "1234"
}
👤 Editar Perfil (usuário autenticado)
PUT /pessoa/editarPerfil
Permite que o usuário altere seu próprio perfil.

json
Copiar
Editar
Request Body:
{
  "password": "user",
  "login": "1234"
}
🔍 Buscar Usuário por ID (somente ADMIN)
GET /pessoa/{id}
Retorna os dados de um usuário específico.

❌ Remover Usuário (somente ADMIN)
DELETE /pessoa/{id}
Remove um usuário pelo ID.

👁️ Visualizar Perfil (usuário autenticado)
GET /pessoa/visualizarPerfil
Retorna os dados do usuário atualmente autenticado.

📋 Listar Todos os Usuários (somente ADMIN)
GET /pessoa/listarTodosUsuarios
Retorna todos os usuários cadastrados.
