FROM openjdk:19-jdk-alpine
COPY target/salestax-0.0.1-SNAPSHOT.jar sales-tax-challenge-1.0.0.jar
ENTRYPOINT ["java","-jar","/sales-tax-challenge-1.0.0.jar","input1.txt"]
