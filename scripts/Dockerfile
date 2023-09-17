FROM openjdk
LABEL name=principal
#RUN
COPY target/principal-api-0.0.1-SNAPSHOT.jar /etc/app.jar
EXPOSE 80
CMD ["java", "-jar", "principal-api-0.0.1-SNAPSHOT.jar"]