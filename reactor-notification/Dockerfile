FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

COPY target/reactor-notification-0.0.1-SNAPSHOT.jar /app/app.jar

ENV JAVA_OPTS="-Xms512m -Xmx1024m"

CMD ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar"]