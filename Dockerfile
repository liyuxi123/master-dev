#基础镜像使用Java
FROM openjdk:8
MAINTAINER Liang Zhang

# 设置时区
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone 

WORKDIR /opt/qxaillm

ADD target/qxaillm-1.jar qxaillm.jar

#运行jar包
RUN bash -c 'touch qxaillm.jar'
ENTRYPOINT ["java", "-jar", "qxaillm.jar"]
EXPOSE 8080
 
