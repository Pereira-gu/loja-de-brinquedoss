FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY . .

# 🔥 adiciona isso aqui
RUN chmod +x mvnw

# builda o projeto
RUN ./mvnw clean package -DskipTests

CMD ["java", "-jar", "target/loja-0.0.1-SNAPSHOT.jar"]
