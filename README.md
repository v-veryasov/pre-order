##### Образовательный проект

###### Commands:
mvnw spring-boot:run

mvnw package -DskipTests && java -jar target/pre-order-0.0.1-SNAPSHOT.jar
mvnw clean package -DskipTests

docker build -t pre-order **.**

docker run -p 8095:8080 pre-order

###### Сделать хранение фото в S3(в будущем)
###### Хранение в FS(на данный момент)

docker-compose up flag -d

docker run -p 8100:8100 api-gateway --network=pre-order

docker run --name=api-gateway --rm -p 8100:8100 api-gateway

kubectl apply -f kube
minikube service api-gateway --url : получам URL или создаёт туннель
minikube service list
kubectl logs api-gateway-79686bbf4f-6w4ds
kubectl get pods --watch
kubectl get services

minikube start --driver=hyperv
minikube delete

### 
https://kubernetes.io/docs/tasks/access-application-cluster/web-ui-dashboard/
https://github.com/kubernetes/dashboard/blob/master/docs/user/access-control/creating-sample-user.md
http: // localhost: 8001 / api / v1 / namespaces / kubernetes-dashboard / services / https: kubernetes-dashboard: / proxy / .

http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/#/log/default/api-gateway-6fffdc84d8-jhm7v/pod?namespace=default&container=api-gateway

kubectl apply -f dashboard/dashboard-adminuser.yaml

kubectl -n kubernetes-dashboard get secret $(kubectl -n kubernetes-dashboard get sa/admin-user -o jsonpath="{.secrets[0].name}") -o go-template="{{.data.token | base64decode}}"

kubectl proxy
