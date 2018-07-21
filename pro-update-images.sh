#每当git代码提交触发CI构建并push最新镜像到hub中，需要更新镜像，重新创建容器

#登录hub
docker login -u -p

#cleanup, 清理容器、清理网络
docker-compose down

#拉取最新的镜像
docker pull image_name

#部署服务
docker-compose -f docker-compose.yml up
