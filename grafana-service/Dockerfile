FROM grafana/grafana
ADD provisioning /etc/grafana/provisioning
ADD grafana.ini /etc/grafana
USER root
RUN apk add --update --no-cache libcrypto1.1=1.1.1q-r0