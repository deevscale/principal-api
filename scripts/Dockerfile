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
ENTRYPOINT ["java", "-jar", "app.jar"]