FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*.jar
ENV SERVER_PORT=8091

EXPOSE $SERVER_PORT
ENTRYPOINT java -jar /opt/pre-order/profile.jar

COPY ${JAR_FILE} /opt/pre-order/profile.jar