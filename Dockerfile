# Используйте официальный образ Java
FROM openjdk:8-jre-alpine

# Создайте директорию приложения в контейнере
WORKDIR /app

# Копируйте JAR-файл в директорию приложения
COPY api_AIntelligence_jar-0.0.3.jar /app/api_AIntelligence_jar-0.0.3.jar

# Установите порт, который ваше приложение будет слушать
EXPOSE 8080

# Запустите приложение при запуске контейнера
CMD ["java", "-jar", "api_AIntelligence_jar-0.0.3.jar"]
