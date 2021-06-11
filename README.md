# Training Project

This application is a booking service
### Microservices: 
Все модули самодостаточные, и могут быть разделены по удаленным репозиториям 

- api-gateway - маршрутизация Zuul(+eureka)
- eureka - Eureka Server
- auth-sso - авторизация и аутентификация OAuth2
- booking - сервис с "бизнес-логикой" 
- profile - сервис с "бизнес-логикой"
- db - модуль наката структуры БД.(для БД в Docker контейнере)

- check-test модуль для тестирования без Spring Security
- auth - авторизация и аутентификация JWT
## Развертывание:
На примере случайного модуля:
```
mvnw package -DskipTests

docker build -t vveryasov/api-gateway:1.0.0 ./api-gateway
docker push vveryasov/api-gateway:1.0.0
```
Выполнить скрипт в init-volumes.bat

Запуск с помощью docker-compose:
```
docker-compose up -d
```

### Работа с kubernetes перенесена в feature/kube
## Useful Commands:
```
docker network create pre-order

docker run -p 8100:8100 api-gateway --network=pre-order

docker tag api-gateway vveryasov/api-gateway:1.0.0

images, rmi, ps 

docker run --name=api-gateway --rm -p 8100:8100 api-gateway
```
###### Сделать хранение фото в S3(в будущем)
###### Хранение в FS(на данный момент)