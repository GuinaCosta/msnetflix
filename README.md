**MSNetflix**

#Instruções para Criação de Ambiente

**Docker Compose**
* Suba os containers de recursos usados pela aplicação:

`docker-compose -f "docker-compose.yml" up -d --build`

* Verifique que os containers estão online:

`docker ps`

Deve ser apresentada os 4 containers abaixo com status UP: 
```
CONTAINER ID        IMAGE                                        COMMAND                  CREATED             STATUS              PORTS                                        NAMES
3fe8fb47023f        ches/kafka                                   "/start.sh"              17 minutes ago      Up 17 minutes       7203/tcp, 0.0.0.0:9092->9092/tcp             netflix-kfk
f12100fc2e67        redis                                        "docker-entrypoint.s…"   18 hours ago        Up 17 minutes       0.0.0.0:6379->6379/tcp                       netflix-redis
7e05aa1a8118        zookeeper                                    "/docker-entrypoint.…"   9 days ago          Up 17 minutes       2888/tcp, 0.0.0.0:2181->2181/tcp, 3888/tcp   netflix-zkpr
b16ced77a5f1        mcr.microsoft.com/mssql/server:2017-latest   "/opt/mssql/bin/sqls…"   9 days ago          Up 17 minutes       0.0.0.0:1433->1433/tcp                       netflix-db
```

#Postman Collection with requests
* Exemplos de chamadas:
https://www.getpostman.com/collections/1828b50f1e312f8fc0ec

#Rodando a Aplicação

...

#Swagger UI Endpoints
* Catalog Search Service: http://localhost:8085/swagger-ui.html
* Catalog Service: http://localhost:8086/swagger-ui.html
* Helpdesk Service: http://localhost:8087/swagger-ui.html