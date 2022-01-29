FROM gradle:jdk11-hotspot as builder

WORKDIR /builder

COPY . .

RUN gradle build

FROM openjdk:11-jdk-bullseye

RUN apt-get update && apt-get install -y locales && locale-gen en_US.UTF-8

RUN locale-gen en_US.UTF-8
ENV LANG en_US.UTF-8
ENV LANGUAGE en_US:en
ENV LC_ALL en_US.UTF-8

COPY --from=builder /builder/build/libs/*.jar /app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
