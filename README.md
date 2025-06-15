POST: http://localhost:8080/auth/register  
Body:
```json
{
  "login": "admin",
  "password": "123",
  "role": "USER"
}
```

---

POST: http://localhost:8080/auth/login  
Body:
```json
{
  "login": "admin",
  "password": "123"
}
```

Retorna um token, pegue esse token, e coloque no header para realizar demais requisições:  
**"Authorization": "Bearer token_gerado"**

---

// SOMENTE ADMINS  
PUT: http://localhost:8080/pessoa/editarPessoa/{id}  
Body:
```json
{
  "password": "admin2",
  "login": "1234"
}
```

---

// USERS  
PUT: http://localhost:8080/pessoa/editarPerfil  
Body:
```json
{
  "password": "user",
  "login": "1234"
}
```

---

// SOMENTE ADMINS  
GET: http://localhost:8080/pessoa/{id}  
Retorna usuário buscado.

---

// SOMENTE ADMINS  
DELETE: http://localhost:8080/pessoa/{id}  
Remove usuário.

---

// USERS  
GET: http://localhost:8080/pessoa/visualizarPerfil  
Retorna usuário logado.

---

// SOMENTE ADMINS  
GET: http://localhost:8080/pessoa/listarTodosUsuarios  
Retorna todos usuários cadastrados.
