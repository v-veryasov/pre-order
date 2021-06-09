FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*.jar
ENV SERVER_PORT=8100 \
    AUTH_SSO_SERVERS_LIST="http://localhost:8090"

EXPOSE $SERVER_PORT
COPY ${JAR_FILE} /opt/pre-order/api-gateway.jar

ENTRYPOINT java -jar /opt/pre-order/api-gateway.jar


