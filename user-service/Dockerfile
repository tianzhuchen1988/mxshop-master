FROM java:8-jre
MAINTAINER Chen Tianzhu "36905602@qq.com"

ADD ./target/user-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/account-service.jar"]

EXPOSE 8900