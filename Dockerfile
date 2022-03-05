FROM openjdk:11-slim
COPY build/libs/TheApp-1.0-SNAPSHOT.jar /home/
WORKDIR /home
CMD ["java","-jar","TheApp-1.0-SNAPSHOT.jar"]