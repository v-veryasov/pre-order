##### Образовательный проект

###### Commands:
mvnw spring-boot:run

mvnw package -DskipTests && java -jar target/pre-order-0.0.1-SNAPSHOT.jar
mvnw clean package -DskipTests

docker build -t pre-order **.**

docker run -p 8095:8080 pre-order

###### Сделать хранение фото в S3
###### Сдлеать хранение в FS