FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*.jar
ENV SERVER_PORT=8182

EXPOSE $SERVER_PORT
ENTRYPOINT java -jar /opt/pre-order/pre-order-app.jar

COPY ${JAR_FILE} /opt/pre-order/pre-order-app.jar

