##### Образовательный проект

###### Commands:
mvnw spring-boot:run

mvnw package && java -jar target/pre-order-0.0.1-SNAPSHOT.jar

docker build -t pre-order-core **.**

docker run -p 8095:8080 pre-order-core