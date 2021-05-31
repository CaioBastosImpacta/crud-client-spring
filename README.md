# CLIENTS' API - CRUD

Aplicação responsável por realizar as seguintes transações na base de dados:
1. Cadastro de um cliente
2. Busca de todos os clientes
3. Busca de um cliente por ID
4. Busca de um cliente por nome
5. Atualização dos dados de um cliente
6. Deletar cliente

Antes de realiza as transações na base de dados, é necessário fazer a autenticação para obter um
token e estar autorizado a acessar os endpoints do CRUD.

Para realizar o download do projeto, pode ser feito de duas maneiras:

1. Realizar o download do projeto pelo GIT

1.1 Clonar o projeto pela URL HTTPs
```bash
https://github.com/CaioBastosImpacta/crud-client-spring.git
```
1.2 Alterar o arquivo application.properties
```bash
spring.datasource.username= -> ADICIONAR O CAMPO USERNAME QUE A APLICAÇÃO DO MYSQL EM SUA MÁQUINA ESPERA
spring.datasource.password= -> ADICIONAR O CAMPO PASSWORD QUE A APLICAÇÃO DO MYSQL EM SUA MÁQUINA ESPERA
```
1.3 Subir a aplicação.

1.4 Realizar o INSERT direto na base de dados, para gerar uma massa válida para obter o token.
```bash
insert into user (id, name, email, password) values (1, 'Caio Bastos', 'caio@teste.com', '"$2a$10$8gHeOyJLCRtVfMrvvT9ht.bUNJca9HLRu125WpJFINsGTea1TkwWK')
```

2. Realizar o download do projeto com a imagem docker.

2.1 Download da imagem DOCKER -> https://hub.docker.com/repository/docker/caiobastos12/crud-client
```bash
docker push caiobastos12/crud-client:1.0.0
```
2.2 Criar uma Network docker
```bash
docker network create --driver bridge crud-client-network
```
2.3 Rodar uma imagem mysql DOCKER e inserir na network criada anteriormente
```bash
docker container run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=[INSERIR A SENHA DO BANCO] --network crud-client-network --name crud-client-mysql mysql:8.0
```
2.4 Rodar uma imagem da aplicação na network criada anteriormente
```bash
docker container run --rm -p 8080:8080 -e DB_HOST=crud-client-mysql --network crud-client-network crud-client:1.0.0
```
2.5 Realizar o INSERT direto na base de dados, para gerar uma massa válida para obter o token.
```bash
insert into user (id, name, email, password) values (1, 'Caio Bastos', 'caio@teste.com', '"$2a$10$8gHeOyJLCRtVfMrvvT9ht.bUNJca9HLRu125WpJFINsGTea1TkwWK')
```

### ENDPOINTS

1 Obter o token:
```bash
ROTA -> localhost:8080/oauth/token
METODO -> POST
AUTHORIZATION -> username: bastos-auth-web / password: bastos123456 
BODY -> [
  username:caio@teste.com
  password:123456
  grant_type:password
]
```
1.1 Cadastrar usuario para novos token
```bash
ROTA -> localhost:8080/fit_app/v1/users
METODO -> POST
AUTHORIZATION -> username: bastos-auth-web / password: bastos123456 
BODY -> {
    "name": "Caio Henrique",
    "email": "caiobastos@teste.com",
    "password": "c123"
}
```
2 Cadastrar o cliente:
```bash
ROTA -> localhost:8080/fit_app/v1/clients 
METODO -> POST
AUTHORIZATION -> Inserir o token obtido no item 1.5
BODY -> {
    "name": "Caio Henrique Bastos",
    "birth_date": "1997-10-13"
}
```
3 Buscar todos os clientes:
```bash
ROTA -> localhost:8080/fit_app/v1/clients
METODO -> GET
AUTHORIZATION -> Inserir o token obtido no item 1.5
```
4 Buscar cliente por ID:
```bash
ROTA -> localhost:8080/fit_app/v1/clients/1
METODO -> GET
AUTHORIZATION -> Inserir o token obtido no item 1.5
```
5 Buscar cliente por NOME:
```bash
ROTA -> localhost:8080/fit_app/v1/clients/name?expand=Caio Henrique Bastos
METODO -> GET
AUTHORIZATION -> Inserir o token obtido no item 1.5
```
6 Atualizar o cliente:
```bash
ROTA -> localhost:8080/fit_app/v1/clients/2
METODO -> PUT
AUTHORIZATION -> Inserir o token obtido no item 1.5
BODY -> {
    "name": "Caio Henrique",
    "birth_date": "1997-09-26"
}
```
7 Deletar o cliente:
```bash
ROTA -> localhost:8080/fit_app/v1/clients/3
METODO -> DELETE
AUTHORIZATION -> Inserir o token obtido no item 1.5
```

8 HealthCheck' verifica se a api está ok:
```bash
ROTA -> http://localhost:8080/fit_app/v1/healthCheck
METODO -> GET
```

9 Swagger:
```bash
http://localhost:8080/swagger-ui.html#/
```

**** Caso tenha problemas com o endpoint, existe uma collection adicionada nos arquivos do git
```bash
CAMINHO -> classpath:Crud.postman_collection.json
```