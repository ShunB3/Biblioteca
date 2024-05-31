FROM openjdk:17
COPY "./target/Biblioteca-1.jar" "app.jar"
EXPOSE 8022
ENTRYPOINT  ["java", "-jar", "app.jar"]