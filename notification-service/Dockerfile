FROM java:8-jre
MAINTAINER Alexander Lukyanchikov <sqshq@sqshq.com>

ADD ./target/notification-service-swarm.jar /app/
ADD ./target/notification-service.war /app/
CMD ["java", "-Xmx200m", "-Djava.net.preferIPv4Stack=true", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005", "-jar", "/app/notification-service-swarm.jar", "/app/notification-service.war"]

EXPOSE 8000