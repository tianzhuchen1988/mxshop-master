FROM java:8-jre
MAINTAINER Chen Tianzhu "36905602@qq.com"

ADD ./target/user-service.jar /app/
CMD ["java", "-Xmx500m", "-jar", "/app/user-service.jar"]

EXPOSE 8900