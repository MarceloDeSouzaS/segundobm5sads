POST: http://localhost:8080/auth/register
Body:
{
  "login": "admin",
  "password": "123",
  "role": "USER"
}


POST: http://localhost:8080/auth/login
Body:
{
  "login": "admin",
  "password": "123"
}

Retorna um token, pegue esse token, e coloque no header para realizar demais requisições "Authorization" : "Bearer: token_gerado"


//SOMENTE ADMINS
PUT: http://localhost:8080/pessoa/editarPessoa/{id} 
Body:
{
  "password": "admin2",
  "login": "1234"
}

//USERS
PUT: http://localhost:8080/pessoa/editarPerfil
Body:
{
  "password": "user",
  "login": "1234"
}

//SOMENTE ADMINS
GET: http://localhost:8080/pessoa/{id} 
retorna usuário buscado.


//SOMENTE ADMINS
DELETE: http://localhost:8080/pessoa/{id} 
remove usuário.


//USERS
GET: http://localhost:8080/pessoa/visualizarPerfil
Retorna usuário logado.

//SOMENTE ADMINS
GET: http://localhost:8080/pessoa/listarTodosUsuarios
Retorna todos usuários cadastrados.
