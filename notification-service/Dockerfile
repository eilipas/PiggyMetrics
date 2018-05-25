FROM java:8-jre
MAINTAINER Alexander Lukyanchikov <sqshq@sqshq.com>

ADD ./target/notification-service-swarm.jar /app/
ADD ./target/notification-service.war /app/
CMD ["java", "-Xmx200m", "-Djava.net.preferIPv4Stack=true", "-jar", "/app/notification-service.jar-swarm.jar", "/app/notification-service.war"]

EXPOSE 8000