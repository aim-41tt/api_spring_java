FROM openjdk:8-jre-alpine

# директория
WORKDIR /app

# JAR-файл
COPY target/api_AIntelligence_jar-0.0.3.jar /app/api_AIntelligence_jar-0.0.3.jar

# директория DataSet
COPY DataSet /app/DataSet

# port
EXPOSE 8080

CMD ["java", "-jar", "api_AIntelligence_jar-0.0.3.jar"]
