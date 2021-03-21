# Create a Spring Native Application

## Requirements

To compile and run this demo you will need:
- JDK 11
- Maven
- Docker

## Setup 

###### Start spring application
```bash
$ mvn package spring-boot:run
```

###### Build the native application

> **Tip**: On MacOS, it is recommended to increase the memory allocated to Docker to at least **`8GB`**, and potentially add more CPUs as well. See this [**Stackoverflow answer**](https://stackoverflow.com/questions/44533319/how-to-assign-more-memory-to-docker-container/44533437#44533437) for more details. On Microsoft Windows, make sure to enable the [**Docker WSL 2 backend**](https://docs.docker.com/docker-for-windows/wsl/) for better performance

```bash
$ mvn spring-boot:build-image
```

###### Run the native application
```bash
$ docker run -p 8080:8080 spring-native-example:1.0.0
```

![alt text](sc.jpg)
