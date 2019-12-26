# From Base image of openjdk 8 on alpine
FROM openjdk:8-alpine

# Change workdir
WORKDIR /opt/app

# Copy the artifact to the location
COPY target/DemoApplication-0.0.1-SNAPSHOT.jar .

# Expose the port
EXPOSE 8080

# Entry point of the applciation
ENTRYPOINT [ "java", "-jar" ]

# parameter to the entrypoint is the jar file
CMD [ "DemoApplication-0.0.1-SNAPSHOT.jar" ]