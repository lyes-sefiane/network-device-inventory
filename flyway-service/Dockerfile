FROM flyway/flyway:8.5.11-alpine
ADD sql_versions /flyway/sqlf
USER root
RUN apk add --update --no-cache libcrypto1.1=1.1.1q-r0