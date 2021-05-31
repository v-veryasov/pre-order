FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*.jar
ENV SERVER_PORT=8085 \
    SERVER_HOST=localhost

EXPOSE $SERVER_PORT
ENTRYPOINT java -jar /opt/pre-order/eureka.jar

COPY ${JAR_FILE} /opt/pre-order/eureka.jar