FROM openjdk:17-jdk-slim-buster
LABEL name=principal
LABEL version=0.0.1
#RUN
#COPY target/principal-api-0.0.1-SNAPSHOT.jar /usr/bin/app.jar
ARG JAR_FILE=../target/*.jar
ENV APP_PATH=/opt/principal-api
COPY ${JAR_FILE} $APP_PATH/app.jar
WORKDIR $APP_PATH
EXPOSE 8080
#CMD ["java", "-jar", "principal-api.jar"]
RUN echo "Starting principal-api"
RUN pwd
#ENTRYPOINT ["java", "-jar", "app.jar"]
# ENTRYPOINT ["java", "-XX:+UseSerialGC", "-jar", "app.jar"]
ENTRYPOINT ["java", "-XX:+UseParallelGC", "-XX:ParallelGCThreads=9", "-XX:MaxGCPauseMilis=3000", "-XXGCTimeRatio=300", "-Xmx2000", "-jar", "app.jar"]
# ENTRYPOINT ["java", "-XX:+UseParNewGC", "-jar", "app.jar"]
# ENTRYPOINT ["java", "-XX:+UseG1GC", "-jar", "app.jar"]
# ENTRYPOINT ["java", "-XX:+UseZGC", "-jar", "app.jar"]
# ENTRYPOINT ["java", "-XX:+UseStringDeDuplication", "-jar", "app.jar"]