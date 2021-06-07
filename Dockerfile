## Satge 1 - Builder
FROM maven:3.6-jdk-11-slim AS builder
ADD . /opt/training

WORKDIR /opt/training

RUN mvn clean install

## Stage 2 - Create docker image
FROM openjdk:8-slim

WORKDIR /opt/training

COPY --from=builder /opt/training/target/dockers-1.0-SNAPSHOT.jar /opt/training/
COPY src/main/resources/application.yaml /opt/training/config/

CMD ["java", "-jar", "dockers-1.0-SNAPSHOT.jar", "--spring.config.location=file:/opt/training/config/application.yaml"]
