FROM java:8-jre
MAINTAINER Chen Tianzhu "36905602@qq.com"

ADD ./target/product-service.jar /app/
CMD ["java", "-Xmx500m", "-jar", "/app/product-service.jar"]

EXPOSE 8901