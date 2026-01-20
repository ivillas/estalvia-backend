FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copiar jar y script wait-for-it
COPY estalvia-backend.jar .
COPY wait-for-it.sh .
RUN chmod +x wait-for-it.sh

EXPOSE 8080

CMD ["./wait-for-it.sh", "mariadb:3306", "--timeout=60", "--", "java", "-jar", "estalvia-backend.jar"]