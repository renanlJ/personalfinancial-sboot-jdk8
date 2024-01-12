FROM gcr.io/distroless/java11-debian11
COPY target/*.jar /app/app.jar
WORKDIR /app
CMD ["app.jar"]