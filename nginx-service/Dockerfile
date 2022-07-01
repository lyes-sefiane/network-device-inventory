FROM nginx:1.22-alpine
ADD conf.d /etc/nginx/conf.d
RUN apk add --update pcre2=10.40-r0 && \
    curl=7.83.1-r2 && \
    rm -rf /var/cache/apk/*