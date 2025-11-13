FROM eclipse-temurin:21-jdk
COPY ./target/crudFutbol-1.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar"]
