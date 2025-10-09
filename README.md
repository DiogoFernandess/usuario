# API de Login com Spring Security e JWT ✨

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)

---

## 🚀 Sobre o Projeto
Este projeto consiste em uma API RESTful robusta para login, autenticação e autorização de usuários, desenvolvida seguindo os padrões REST. Construída com Java e o ecossistema Spring, a aplicação utiliza Spring Security para um controle de acesso seguro e JSON Web Tokens (JWT) para gerenciar sessões de forma stateless, ideal para arquiteturas de microsserviços e aplicações modernas.

O principal objetivo é oferecer um serviço de login seguro, performático e escalável, que possa ser facilmente integrado a qualquer sistema que necessite de autenticação.

---

## 🎯 Funcionalidades
- ✅ **Cadastro de Usuários:** Endpoint para registro de novos usuários com dados essenciais e atribuição de perfis (roles).
- ✅ **Autorização Baseada em Token:** Proteção de rotas da API utilizando filtros do Spring Security, que validam o token JWT enviado no cabeçalho `Authorization` a cada requisição.
- ✅ **Validação de Token:** Mecanismos para garantir a integridade e a validade do token, verificando sua assinatura e data de expiração.
- ✅ **Atualização de Dados:** Métodos para atualização de dados como atualização de endereço, telefone.
- ✅ **Busca de Dados:** Métodos para busca de dados do usuário por email.
- ✅ **Delete:** Método para remoção de dados por ID.
---

## 🔧 Tecnologias Utilizadas
A API foi construída com as seguintes tecnologias e bibliotecas:

* **[Java](https://www.oracle.com/java/technologies/downloads/):** Linguagem de programação principal do projeto.
* **[Spring Boot](https://spring.io/projects/spring-boot):** Framework que agiliza a configuração e o desenvolvimento de aplicações stand-alone.
* **[Spring Security](https://spring.io/projects/spring-security):** Para a implementação robusta da camada de segurança, incluindo autenticação e autorização.
* **[Spring Data JPA](https://spring.io/projects/spring-data-jpa):** Facilita a implementação da camada de persistência de dados.
* **[PostgreSQL](https://www.postgresql.org/):** Banco de dados relacional utilizado para a persistência dos dados da aplicação.
* **[JWT (JSON Web Token)](https://jwt.io/):** Utilizado para a criação e validação dos tokens de autenticação, permitindo uma comunicação stateless e segura.
* **[Gradle](https://gradle.org/):** Ferramenta para gerenciamento de dependências e build do projeto.
* **[Lombok](https://projectlombok.org/):** Biblioteca para reduzir a verbosidade do código (boilerplate) com anotações.

---

## 📖 Documentação (Swagger)
A documentação de todos os endpoints da API foi gerada utilizando **Swagger (OpenAPI)**, o que facilita a visualização e a interação com os recursos disponíveis.

Para acessar a documentação interativa, inicie a aplicação e acesse o seguinte endereço no seu navegador:

**`http://localhost:8080/swagger-ui.html`**

Lá, você poderá ver todos os endpoints, seus parâmetros, corpos de requisição esperados e respostas, além de poder testá-los diretamente pela interface.



---

## 👨‍💻 Autor

**Diogo Fernandes**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/i-diogo-fernandes/)
[![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/DiogoFernandess)

---
