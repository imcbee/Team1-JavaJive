FROM gradle:7 as builder
COPY --chown=gradle:gradle . /app
WORKDIR /app
RUN gradle bootJar

FROM openjdk:8-jdk-alpine
EXPOSE 8080
VOLUME /tmp
ARG LIBS=app/build/libs
COPY --from=builder ${LIBS}/ /app/lib
ENTRYPOINT ["java","-jar","./app/lib/MCCTeam1JavaJive-0.0.1-SNAPSHOT.jar"]