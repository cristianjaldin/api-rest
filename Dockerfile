# Multi stage build

FROM maven:3.5-alpine as builder 

COPY . /api-rest

RUN cd /api-rest && mvn package

FROM openjdk:8-alpine

COPY --from=builder /api-rest/target/api-rest-0.0.1-SNAPSHOT.jar /opt/api-rest.jar

CMD java -jar /opt/api-rest.jar