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

# -- No GC definition
ENTRYPOINT ["java", "-Xss2M", "-Xms5M", "-Xmx2G", "-jar", "app.jar"]

# -- Serial GC
#ENTRYPOINT ["java", "-XX:+UseSerialGC", "-jar", "app.jar"]

# -- Parallel GC
#ENTRYPOINT ["java", "-XX:+UseParallelGC", "-XX:ParallelGCThreads=9", "-XX:MaxGCPauseMillis=3000", "-XX:GCTimeRatio=300", "-Xmx20M", "-jar", "app.jar"]

# -- New parallel (DEPRECATED)
#ENTRYPOINT ["java", "-XX:+UseParNewGC", "-jar", "app.jar"]

# -- G1
#ENTRYPOINT ["java", "-XX:+UseG1GC", "-jar", "app.jar"]

# -- Z1
#ENTRYPOINT ["java", "-XX:+UseZGC", "-jar", "app.jar"]

# -- String deduplication
#ENTRYPOINT ["java", "-XX:+UseStringDeDuplication", "-jar", "app.jar"]