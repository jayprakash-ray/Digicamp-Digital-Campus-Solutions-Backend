# FROM openjdk:8
# COPY target/digicamp_application-v1.jar ./
# WORKDIR ./
# CMD ["java", "-jar", "digicamp_application-v1.jar"]
# #FROM maven:3.8.2-jdk-8
# #WORKDIR ./
# #COPY . .
# #RUN mvn clean install
# #CMD mvn spring-boot:run

FROM openjdk:8
ADD  digicamp_application-v1.jar digicamp_application-v1.jar
ENTRYPOINT ["java","-jar","digicamp_application-v1.jar"]
