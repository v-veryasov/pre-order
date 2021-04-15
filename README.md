##### Образовательный проект

###### Commands:
mvnw spring-boot:run

mvnw package && java -jar target/pre-order-0.0.1-SNAPSHOT.jar
mvnw clean package -DskipTests

docker build -t pre-order **.**

docker run -p 8095:8080 pre-order