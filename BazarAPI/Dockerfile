FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/BazarAPI-0.0.1.jar
COPY ${JAR_FILE} app_bazarapi.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_bazarapi.jar"]