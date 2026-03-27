FROM openjdk:21

WORKDIR /app

COPY . .

RUN ./mvnw clean package -DskipTests

EXPOSE 10000

CMD ["java", "-jar", "target/Eventmanager-0.0.1-SNAPSHOT.jar"]