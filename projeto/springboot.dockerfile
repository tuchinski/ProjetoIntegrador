FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
# ADD wait-for-it.sh .
EXPOSE 8080
# ENTRYPOINT ["sleep","30", "&&","java", "-jar", "app.jar"]
ENTRYPOINT sleep 60 && java -jar app.jar
# ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]