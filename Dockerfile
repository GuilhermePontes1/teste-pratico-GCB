FROM openjdk:11

ARG PROFILE
ARG ADDITTIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/teste-pratico-gcb

COPY /target/teste-pratico-gcb*.jar teste-pratico-gcb.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 5005
EXPOSE 8080

CMD java ${ADDITIONAL_OPTS} -jar teste-pratico-gcb.jar --spring.profiles.active=${PROFILE}