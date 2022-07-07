FROM nginx:1.23-alpine
LABEL maintainer="Lyes S."
RUN addgroup -S nginx-service && \
    adduser -S -G nginx-service nginx-service
ADD conf.d /etc/nginx/conf.d
RUN apk upgrade --update-cache --available && \
    apk add openssl=1.1.1q-r0  \
    curl=7.83.1-r2 \
    pcre2=10.40-r0 && \
    rm -rf /var/cache/apk/*