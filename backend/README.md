# Backend

The backend for the Aura Tower is a modular Spring Boot application that allows you to write your own plugins for IoT devices of your choice. The project exposes endpoints for dashboard and allows gathering data from IoT devices. 


## Requirements

The list of tools required to build and run the project:

* [JDK 21](https://openjdk.java.net/projects/jdk/21/)

## Building

In order to build project use:

If you have maven installed
```bash
mvn clean package
```

or if you don't have maven installed then use:


for linux
```bash
./mvnw clean package
```

for windows
```bash
./mvnw.cmd clean package
```
