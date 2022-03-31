FROM openjdk:8-jdk-alpine
COPY target/ticket-spring-boot.jar /app/
COPY config/* /app/config/
WORKDIR /app
ENTRYPOINT ["java","-jar","ticket-spring-boot.jar"]