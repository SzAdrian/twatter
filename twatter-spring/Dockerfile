FROM maven:3.6.3-jdk-14 AS MAVEN_BUILD

COPY ./ ./

RUN mvn clean package -Dmaven.test.skip=true 

FROM openjdk:14-alpine

COPY --from=MAVEN_BUILD /target/twatter-spring-0.0.1-SNAPSHOT.jar /twatter-spring.jar
CMD ["java", "-jar", "/twatter-spring.jar"]