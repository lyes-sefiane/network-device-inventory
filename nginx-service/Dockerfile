FROM nginx:1.22-alpine
ADD conf.d /etc/nginx/conf.d
USER root
RUN apk add --update libcrypto1.1=1.1.1q-r0 pcre2=10.40-r0 curl=7.83.1-r2 && \
    rm -rf /var/cache/apk/*