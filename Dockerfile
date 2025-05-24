FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/InternStudentService-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
