FROM openjdk:11

ARG PROFILE
ARG ADDITTIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/spring_boot

COPY /target/teste-pratico-GCB*jar teste-pratico-GCB.jar

SHELL ["/bin/sh,", "c"]

EXPOSE 5005
EXPOSE 8080

CMD java ${ADDITIONAL_OPTS} -jar teste-pratico-GCB.jar --spring.profiles.active=${PROFILE}