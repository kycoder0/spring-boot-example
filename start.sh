docker build -t spring-pg-db -f db.Dockerfile .

docker container stop spring-pg-container
docker container rm spring-pg-container

docker run -d --name spring-pg-container -p 5432:5432 spring-pg-db


docker build -t spring-prom -f prom.Dockerfile .

docker container stop spring-prom-container
docker container rm spring-prom-container

docker run -d --name spring-prom-container -p 9090:9090 spring-prom