FROM java:8-jre
MAINTAINER Chen Tianzhu "36905602@qq.com"

ADD ./target/mxshop-monitor.jar /app/
CMD ["java", "-Xmx500m", "-jar", "/app/mxshop-monitor.jar"]

EXPOSE 8080