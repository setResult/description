FROM openjdk:8-jre
COPY target/ROOT.jar /data/
WORKDIR /data
CMD ["java","-jar","ROOT.jar"]