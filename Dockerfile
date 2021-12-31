FROM maven:3-amazoncorretto-11 as builder
WORKDIR /network-device-inventory
COPY pom.xml /network-device-inventory
COPY src /network-device-inventory
RUN mvn clean install

FROM amazoncorretto:11-alpine
LABEL maintainer=lyes.sefiane@gmail.com
WORKDIR ./network-device-inventory-service
COPY --from=builder /network-device-inventory/target/network-device-inventory-0.0.1-SNAPSHOT.jar /network-device-inventory-service/network-device-inventory.jar
RUN apk add --update && \
    rm -rf /var/cache/apk/* && \
    rm -rf /network-device-inventory \
EXPOSE 8080
ENTRYPOINT ["java","-jar","network-device-inventory.jar"]