FROM amazoncorretto:11-alpine
LABEL maintainer=lyes.sefiane@gmail.com
WORKDIR network-device-inventory-service
COPY network-device-inventory/network-device-inventory-service/target/network-device-inventory-service-0.0.1-SNAPSHOT.jar network-device-inventory.jar
RUN apk add --update && \
    rm -rf /var/cache/apk/*
EXPOSE 8080
ENTRYPOINT ["java","-jar","network-device-inventory.jar"]