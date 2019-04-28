FROM maven:3.5-jdk-8

COPY src /usr/src/awesome/src
COPY pom.xml /usr/src/awesome
RUN mvn -f /usr/src/awesome/pom.xml clean package -DskipTests
CMD cp /usr/src/awesome/target/*.jar /opt/app.jar

FROM openjdk:8-jdk-alpine
ENTRYPOINT ["java","-jar","/opt/app.jar"]
