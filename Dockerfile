FROM openjdk:8-jre-slim
COPY ./target/metrics-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app/
EXPOSE 8001
ENTRYPOINT exec java $JAVA_OPTS -jar /usr/app/metrics-0.0.1-SNAPSHOT.jar