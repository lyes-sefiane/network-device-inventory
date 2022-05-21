# Network Device Inventory Microservices

![GitHub Workflow Status (branch)](https://img.shields.io/github/workflow/status/lyes-s/network-device-inventory/Java%20CI%20with%20Maven/master)
[![CodeQL](https://github.com/lyes-s/network-device-inventory/workflows/CodeQL/badge.svg)](https://github.com/lyes-s/network-device-inventory/actions?query=workflow%3ACodeQL)
![GitHub top language](https://img.shields.io/github/languages/top/lyes-s/network-device-inventory)
![Docker Pulls](https://img.shields.io/docker/pulls/lsefiane/network-device-inventory)
![GitHub release (latest by date)](https://img.shields.io/github/v/release/lyes-s/network-device-inventory)
![GitHub commit activity (branch)](https://img.shields.io/github/commit-activity/y/lyes-s/network-device-inventory/master)
![GitHub Repo stars](https://img.shields.io/github/stars/lyes-s/network-device-inventory?style=social)
[![license](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/lyes-s/network-device-inventory/blob/master/LICENSE.md)

## Network Device Inventory Microservices Wiki

* [lyes-s/network-device-inventory-microservices/wiki](https://github.com/lyes-s/network-device-inventory/wiki)


### Network Device Inventory Service Documentation

* [lyes-s/network-device-inventory-service/](https://github.com/lyes-s/network-device-inventory/tree/master/network-device-inventory-service)

```
COMPOSE_PROFILES=inventory docker-compose --env-file .env  up -d
```

![Image](https://raw.githubusercontent.com/wiki/lyes-s/network-device-inventory/images/inventory-restful-web-service.PNG)

### Monitoring Documentation

* [lyes-s/network-device-inventory/monitoring/](https://github.com/lyes-s/network-device-inventory/wiki/Monitoring)

```
COMPOSE_PROFILES=inventory,monitoring docker-compose --env-file .env  up -d
```

![Image](https://raw.githubusercontent.com/wiki/lyes-s/network-device-inventory/images/monitoring-system-design-v2.PNG)


## Requirements
```
1. Java 11.x.y

2. Maven 3.x.y

3. Docker 3.x.y
```

## Git Clone
```
https://github.com/lyes-s/network-device-inventory.git
```

## Features Roadmap

* Build Docker Images In a [GitLab](https://about.gitlab.com/) CI Pipeline
* Design and Develop a Graph Service with [GO](https://go.dev/)
* Integrate & Implement [CQRS](https://www.confluent.io/blog/event-sourcing-cqrs-stream-processing-apache-kafka-whats-connection/) with [Kafka](https://kafka.apache.org/)
* Integrate [Graph Visualization](https://github.com/lyes-s/graph-visualization)
* Secure Network Device Inventory & Graph Services with [Keycloak](https://www.keycloak.org/)
* Centralize Tracing with [ELK Stack](https://www.elastic.co/elastic-stack/)
* Deploy to [Kubernetes](https://kubernetes.io/)

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

[Please make sure to update tests as appropriate](https://github.com/lyes-s/network-device-inventory/wiki/Application-Test-Suite-with-JUnit-5-&-Mockito-%F0%9F%8D%B8).

## License

[MIT](https://github.com/lyes-s/network-device-inventory/blob/master/LICENSE.md)
