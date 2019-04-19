**MSNetflix**

#Instruções para Criação de Ambiente

**Postgresql Docker**
* docker pull postgres
* docker pull dpage/pgadmin4
* docker network create --driver bridge postgres-network
*  docker run --name netflix-postgres --network=postgres-network -e "POSTGRES_PASSWORD=myNetflix" -p 5432:5432 -v E:\docker-data\postgres\data:/var/lib/postgresql/data -d postgres
* docker ps

#Rodando a Aplicação

