FROM openjdk:8
ADD  target/digicamp_application-v1.jar digicamp_application-v1.jar
ENTRYPOINT ["java","-jar","digicamp_application-v1.jar"]
