# **MSNetflix**

**Projeto também disponível no GitLab em https://gitlab.com/LFrigoDeSouza/msnetflix

# Instruções para Criação de Ambiente

**Docker Compose**
* Suba os containers de recursos usados pela aplicação:

`docker-compose -f "docker-compose.yml" up -d --build`

* Verifique que os containers estão online:

`docker ps`

Deve ser apresentada os 4 containers abaixo com status UP: 
```
CONTAINER ID        IMAGE                                        COMMAND                  CREATED             STATUS              PORTS                                                NAMES
95b975eec1e2        wurstmeister/kafka                           "start-kafka.sh"         33 hours ago        Up About an hour    0.0.0.0:9092->9092/tcp                               netflix-kfk
0bf8b5e37ec8        wurstmeister/zookeeper                       "/bin/sh -c '/usr/sb…"   34 hours ago        Up About an hour    22/tcp, 2888/tcp, 3888/tcp, 0.0.0.0:2181->2181/tcp   netflix-zkpr
1904ac7bc293        mcr.microsoft.com/mssql/server:2017-latest   "/opt/mssql/bin/sqls…"   35 hours ago        Up About an hour    0.0.0.0:1433->1433/tcp                               netflix-db
f2e9788809d5        redis                                        "docker-entrypoint.s…"   35 hours ago        Up About an hour    0.0.0.0:6379->6379/tcp                               netflix-redis
```

# Postman Collection with requests
* Exemplos de chamadas:
https://www.getpostman.com/collections/1828b50f1e312f8fc0ec

# Rodando a Aplicação

Executar no servidor de banco de dados o script em:

`Scripts\Criacao DB.sql`

* server: localhost,1433
* user: sa
* password: myNetflixDb@2018

Na raiz do projeto instalar as dependências via Maven:

`mvn install`

# Swagger UI Endpoints
* Catalog Search Service: http://localhost:8085/swagger-ui.html
* Catalog Service: http://localhost:8086/swagger-ui.html
* Helpdesk Service: http://localhost:8087/swagger-ui.html
* Watchlist Service: http://localhost:8088/swagger-ui.html

# JAVADOC

Documentação de classes e métodos disponibilizadas em:

`javadoc\index.html`

