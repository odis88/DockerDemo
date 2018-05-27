FROM java:8-jre

ADD ./build/libs/service-gateway.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/service-gateway.jar"]

EXPOSE 8080