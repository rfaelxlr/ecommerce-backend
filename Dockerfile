FROM openjdk:17
MAINTAINER Rafael Lima
EXPOSE 8080

COPY target/ecommerce-0.0.1-SNAPSHOT.jar my.jar
ENTRYPOINT ["java","-jar","/my.jar"]
