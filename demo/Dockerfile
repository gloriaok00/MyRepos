FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER zhangyu121.ok@163.com

RUN mkdir -p /dockerfilejavademo

WORKDIR /dockerfilejavademo

EXPOSE 8047

ADD ./demo-0.0.1-SNAPSHOT.jar ./

CMD java -jar demo-0.0.1-SNAPSHOT.jar