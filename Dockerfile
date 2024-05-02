FROM jelastic/maven:3.9.5-openjdk-21 AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -B package --file pom.xml


FROM openjdk:21-jdk-oracle
WORKDIR /app
COPY --from=build /workspace/target/*shaded.jar /app
ENTRYPOINT ["java", "-jar", "/app/gRPCThesisTestStorageNode-1.0-SNAPSHOT.jar"]