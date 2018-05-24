FROM java:8-jre
MAINTAINER Alexander Lukyanchikov <sqshq@sqshq.com>

ADD ./target/account-service-swarm.jar /app/
ADD ./target/account-service.war /app/
CMD ["java", "-Xmx200m", "-Djava.net.preferIPv4Stack=true", "-jar", "/app/account-service-swarm.jar", "account-service.war"]

EXPOSE 6000