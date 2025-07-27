FROM openjdk:17

# Set working directory in the container
WORKDIR /

# Copy the Spring Boot JAR file to the container
COPY target/Front-Office-Portal.war FrontOfficePortal.war

# Run the application
ENTRYPOINT ["java", "-jar", "FrontOfficePortal.war"]
