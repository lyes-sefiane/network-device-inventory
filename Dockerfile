FROM maven:3-amazoncorretto-11 as builder
WORKDIR /network-device-inventory
COPY . /network-device-inventory
RUN mvn clean install --projects network-device-inventory-service --also-make

FROM amazoncorretto:11-alpine
LABEL maintainer=lyes.sefiane@gmail.com
WORKDIR /network-device-inventory-service
COPY --from=builder /network-device-inventory/network-device-inventory-service/target/network-device-inventory-service-0.0.1-SNAPSHOT.jar /network-device-inventory-service/network-device-inventory.jar
RUN apk add --update && \
    rm -rf /var/cache/apk/* && \
    rm -rf /network-device-inventory \
EXPOSE 8080
ENTRYPOINT ["java","-jar","network-device-inventory.jar"]