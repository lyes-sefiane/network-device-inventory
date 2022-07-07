FROM flyway/flyway:8.5.11-alpine
LABEL maintainer="Lyes S."
ADD sql_versions /flyway/sqlf
USER root
RUN apk upgrade --update-cache --available && \
    apk add openssl=1.1.1q-r0 && \
    rm -rf /var/cache/apk/*