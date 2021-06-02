FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*.jar
ENV SERVER_PORT=8090

EXPOSE $SERVER_PORT
COPY ${JAR_FILE} /opt/pre-order/auth-sso.jar

ENTRYPOINT java -jar /opt/pre-order/auth-sso.jar


