FROM java:8-jre
MAINTAINER Chen Tianzhu "36905602@qq.com"

ADD ./target/mxshop-gateway.jar /app/
CMD ["java", "-Xmx500m", "-jar", "/app/mxshop-gateway.jar"]

EXPOSE 4000