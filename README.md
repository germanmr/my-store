# my-store

This project is a Spring boot app for Demo purposes.
The idea is to expose a Restful API

## Getting Started

### Prerequisites
* Git
* JDK 8 or later
* Maven 3.0 or later

### Clone
To get started you can simply clone this repository using git:
```
git clone https://github.com/germanmr/my-store.git
cd my-store
```

### Configuration

The configuration is located in `src/resources/application.properties`.

### Build an executable WAR
You can run the application from the command line using:
```
mvn spring-boot:run
```
Or you can build a single executable WAR file that contains all the necessary dependencies, classes, and resources with:
```
mvn clean package
```
Then you can run the JAR file with:
```
java -jar target/*.jar
```
*Instead of `mvn` you can also use the maven-wrapper `./mvnw` to ensure you have everything necessary to run the Maven build.*

### Deploy to Docker Containers
Build image:
```
docker image build -t my-store .
```
Run image:
```
docker container run -p 8080:8080 -d my-store
```
this returns then id:

Logs
```
docker container logs [id]
```
Stop
```
docker container stop [id]
```

Remove
```
docker image rm my-store
```

```
docker container rm  [containerId]
```
