FROM openjdk:8-jdk-alpine
ENTRYPOINT ["/usr/bin/java", "-jar","/usr/share/foo/app.jar"]

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
ADD target/lib           /usr/share/foo/lib
# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/foo/app.jar