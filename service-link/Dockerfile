FROM java:8-jre

ADD ./build/libs/service-link.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/service-link.jar"]

EXPOSE 8989