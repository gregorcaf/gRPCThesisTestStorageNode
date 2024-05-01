FROM openjdk:21-jdk-oracle
WORKDIR /app/
COPY out/artifacts/gRPCThesisTestStorageNode_jar/gRPCThesisTestStorageNode.jar /app/
ENTRYPOINT ["java", "-jar", "/app/gRPCThesisTestStorageNode.jar"]