# Training Project

This application is a booking service
### Microservices: 
Все модули самодостаточные, и могут быть разделены по удаленным репозиториям 

- api-gateway - маршрутизация Zuul(+eureka)
- eureka - Eureka Server
- auth-sso - авторизация и аутентификация OAuth2
- booking - сервис с "бизнес-логикой" 
- profile - сервис с "бизнес-логикой"
- db - модуль наката структуры БД.(для БД в Docker) 
- kube - папка с настройками развертывания(Kubernetes API)


- auth - авторизация и аутентификация JWT
## Развертывание:
На примере случайного модуля:
```
mvnw package -DskipTests

docker build -t vveryasov/api-gateway:1.0.0 ./api-gateway
docker push vveryasov/api-gateway:1.0.0
```
Запуск с помощью docker-compose:
```
docker-compose up flag -d
```
Для работы kubernetes требуется предварительная настройка "окружения" через PowerShell.exe:

- kubectl - CLI kubernetes 
- Minikube - tool для запуска одноузлового кластер

После того, как все образы залиты в Docker Hub, запуск в кластере kubernetes:
```
kubectl apply -f kube
```
## Useful Commands:
```
docker network create pre-order

docker run -p 8100:8100 api-gateway --network=pre-order

docker tag api-gateway vveryasov/api-gateway:1.0.0

images, rmi, ps 

docker run --name=api-gateway --rm -p 8100:8100 api-gateway
```
```
minikube start --driver=hyperv
minikube delete
minikube service list
```
получаем URL или создаёт туннель(если поднять кластен без --driver=hyperv):
```
minikube service api-gateway --url
```
```
kubectl logs api-gateway-79686bbf4f-6w4ds
kubectl get pods --watch
kubectl get services
```
### Dashboard kubernetes
TODO: доделать

https://kubernetes.io/docs/tasks/access-application-cluster/web-ui-dashboard/

https://github.com/kubernetes/dashboard/blob/master/docs/user/access-control/creating-sample-user.md

http: // localhost: 8001 / api / v1 / namespaces / kubernetes-dashboard / services / https: kubernetes-dashboard: / proxy / .

http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/#/log/default/api-gateway-6fffdc84d8-jhm7v/pod?namespace=default&container=api-gateway
```
kubectl apply -f dashboard/dashboard-adminuser.yaml

kubectl -n kubernetes-dashboard get secret $(kubectl -n kubernetes-dashboard get sa/admin-user -o jsonpath="{.secrets[0].name}") -o go-template="{{.data.token | base64decode}}"

kubectl proxy
```
###### Сделать хранение фото в S3(в будущем)
###### Хранение в FS(на данный момент)