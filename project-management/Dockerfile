FROM ubuntu:latest

LABEL maintainer="Jayman Rana <jayman.code@gmail.com>"

ENV version=aws-db-usage

ENV dbuser=postgres
ENV dbpass=password321
ENV jdbcurl=jdbc:postgresql://database-1.clk6ayymaplt.us-east-1.rds.amazonaws.com:5432/postgres

RUN apt-get update && apt-get install -y openjdk-21-jdk

WORKDIR /usr/local/bin

ADD target/pma-app.jar .

ENTRYPOINT ["java", "-jar", "pma-app.jar"]