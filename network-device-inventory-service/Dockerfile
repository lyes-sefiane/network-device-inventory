FROM amazoncorretto:11-alpine
LABEL maintainer="Lyes S."
RUN addgroup -S network-device-inventory-service && \
    adduser -S -G network-device-inventory-service network-device-inventory-service
WORKDIR network-device-inventory-service
COPY ./target/network-device-inventory-service-0.0.1-SNAPSHOT.jar network-device-inventory.jar
RUN apk upgrade --update-cache --available && \
    apk add openssl=1.1.1q-r0 && \
    rm -rf /var/cache/apk/*
EXPOSE 8080
ENTRYPOINT ["java","-jar","network-device-inventory.jar"]