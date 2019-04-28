FROM maven:3.5-jdk-8 as BUILD

COPY src /usr/src/awesome/src
COPY pom.xml /usr/src/awesome
RUN mvn -f /usr/src/awesome/pom.xml clean package -DskipTests


FROM openjdk:8-jdk-alpine
COPY --from=BUILD /usr/src/awesome/target/*.jar /opt/app.jar

ENTRYPOINT ["java","-jar","/opt/app.jar"]
