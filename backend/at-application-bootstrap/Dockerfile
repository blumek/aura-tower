FROM eclipse-temurin:21-jre
COPY target/at-application-bootstrap-exec.jar application.jar

ENV JAVA_OPTIONS \
    -Dfile.encoding=UTF-8

EXPOSE 8080

SHELL ["/bin/bash", "-c"]
CMD bash -c "java ${JAVA_OPTIONS} -jar application.jar"