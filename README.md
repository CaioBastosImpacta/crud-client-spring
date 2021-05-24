# CLIENTS' API - CRUD

### Network docker
```bash
docker network create --driver bridge crud-client-network
```

### Rodar imagem docker mysql
```bash
docker container run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=Palmeiras2608! --network crud-client-network --name crud-client-mysql mysql:8.0
```

### Rodar imagem docker API
```bash
docker container run --rm -p 8080:8080 -e DB_HOST=crud-client-mysql --network crud-client-network crud-client:1.0.0
```

### Comando para inserir um usuario no banco
```bash
insert into user (id, name, email, password) values (1, 'Caio Bastos', 'caio@teste.com', '"$2a$10$8gHeOyJLCRtVfMrvvT9ht.bUNJca9HLRu125WpJFINsGTea1TkwWK')
```