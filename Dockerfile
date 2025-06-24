#traemos la imagen de jdk
FROM openjdk:17-jdk-alpine
#creamos directorio en el contenedor
WORKDIR /app
#copeamos del target el jar
COPY target/categoria-service-0.0.1-SNAPSHOT.jar categoria-service-app.jar
#exponemos puerto informativo
EXPOSE 8080
#comando para ejecutar la app
ENTRYPOINT ["java" ,"-jar" ,"categoria-service-app.jar"]