FROM eclipse-temurin:21-jre
COPY target/application-bootstrap-exec.jar application-bootstrap-exec.jar

ENV JAVA_OPTIONS \
    -Dfile.encoding=UTF-8

EXPOSE 8080

SHELL ["/bin/bash", "-c"]
CMD bash -c "java ${JAVA_OPTIONS} -jar application-bootstrap-exec.jar"