FROM amazoncorretto:26 AS build
WORKDIR /app
COPY . .
RUN dnf install -y findutils && dnf clean all
RUN chmod +x gradlew
RUN ./gradlew bootJar --no-daemon

FROM amazoncorretto:26
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
