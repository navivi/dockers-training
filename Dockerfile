FROM openjdk:8-slim

WORKDIR /opt/training

COPY target/dockers-1.0-SNAPSHOT.jar /opt/training/
COPY src/main/resources/application.yaml /opt/training/config/

CMD ["java", "-jar", "dockers-1.0-SNAPSHOT.jar", "--spring.config.location=file:/opt/training/config/application.yaml"]
