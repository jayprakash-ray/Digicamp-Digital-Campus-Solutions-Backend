FROM openjdk:8
COPY target/digicamp_application-v1.jar ./
WORKDIR ./
CMD ["java", "-jar", "digicamp_application-v1.jar"]
