FROM java:8-jre
MAINTAINER Chen Tianzhu "36905602@qq.com"

ADD ./target/mxshop-auth.jar /app/
CMD ["java", "-Xmx500m", "-jar", "/app/mxshop-auth.jar"]

EXPOSE 5000