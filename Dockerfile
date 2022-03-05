FROM openjdk:11-slim
COPY build/libs/MP23-1.0-SNAPSHOT.jar /home/
WORKDIR /home
CMD ["java","-jar","MP23-1.0-SNAPSHOT.jar"]