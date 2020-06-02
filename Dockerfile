From openjdk:8
copy ./target/my-store-0.0.1-SNAPSHOT.jar my-store-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","my-store-0.0.1-SNAPSHOT.jar"]