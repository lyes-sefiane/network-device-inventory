# GitHub Badges

[![CircleCI](https://circleci.com/gh/lyes-s/network-device-inventory/tree/master.svg?style=shield)](https://circleci.com/gh/lyes-s/network-device-inventory/tree/master)
![Snyk Vulnerabilities for GitHub Repo](https://img.shields.io/snyk/vulnerabilities/github/lyes-s/network-device-inventory)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=lyes-s_network-device-inventory&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=lyes-s_network-device-inventory)
![GitHub top language](https://img.shields.io/github/languages/top/lyes-s/network-device-inventory)
![GitHub release (latest by date)](https://img.shields.io/github/v/release/lyes-s/network-device-inventory)
![GitHub Release Date](https://img.shields.io/github/release-date/lyes-s/network-device-inventory)
![GitHub commit activity (branch)](https://img.shields.io/github/commit-activity/y/lyes-s/network-device-inventory/master)
![GitHub Repo stars](https://img.shields.io/github/stars/lyes-s/network-device-inventory?style=social)
[![license](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/lyes-s/network-device-inventory/blob/master/LICENSE.md)


# Network Device Inventory Microservices

* [lyes-s/network-device-inventory-microservices/wiki](https://github.com/lyes-s/network-device-inventory/wiki)

## The Twelve Factor App Methodology

* [lyes-s/the-twelve-factor-app-methodology/](https://github.com/lyes-s/network-device-inventory/wiki/The-Twelve-Factor-App-Methodology-%F0%9F%94%A5)

## Network Device Inventory Service Documentation

* [lyes-s/network-device-inventory-service/](https://github.com/lyes-s/network-device-inventory/tree/master/network-device-inventory-service)

Note :

* Replace 'expose' by 'port' in the network-device-inventory.yml so that the service(s) will be reachable outside the docker for this context

```
cd docker-compose/

docker-compose -f network-device-inventory.yml --env-file .env  up -d
```

![Image](https://raw.githubusercontent.com/wiki/lyes-s/network-device-inventory/images/inventory-restful-web-service.PNG)

# Monitoring Documentation

* [lyes-s/network-device-inventory/monitoring/](https://github.com/lyes-s/network-device-inventory/wiki/Monitoring)

```
cd docker-compose/

docker-compose -f network-device-inventory.yml -f monitoring.yml -f gateway.yml --env-file .env  up -d
```

![Image](https://raw.githubusercontent.com/wiki/lyes-s/network-device-inventory/images/monitoring-system-design-v2.PNG)


# Snyk: 'So Now You Know' Documentation

* [lyes-s/network-device-inventory/Snyk-Securing-Code-Dependencies-Containers-and-Infrastructure-as-Code/](https://github.com/lyes-s/network-device-inventory/wiki/Snyk-Securing-Code,-Dependencies,-Containers-and-Infrastructure-as-Code)

![Image](https://raw.githubusercontent.com/wiki/lyes-s/network-device-inventory/images/CircleCiBuild.PNG)


# SonarCloud: Code Quality and Code Security Documentation

* [lyes-s/network-device-inventory/SonarCloud-Code-Quality-and-Code-Security/](https://github.com/lyes-s/network-device-inventory/wiki/SonarCloud-Code-Quality-and-Code-Security)

![Image](https://raw.githubusercontent.com/wiki/lyes-s/network-device-inventory/images/sonarcloud-v3.PNG)


# CircleCI: Continuous Integration and Delivery Documentation

* [lyes-s/network-device-inventory/CircleCI-Continuous-Integration-and-Delivery/](https://github.com/lyes-s/network-device-inventory/wiki/CircleCI-Continuous-Integration-and-Delivery)

![Image](https://raw.githubusercontent.com/wiki/lyes-s/network-device-inventory/images/release-workflow-v6.PNG)

# Requirements
```
1. Java 11.x.y

2. Maven 3.x.y

3. Docker 3.x.y
```

# Git Clone
```
https://github.com/lyes-s/network-device-inventory.git
```

# Completed Features

- [x] Build Docker Images In a [CircleCI](https://circleci.com/) Pipeline & Push them to [DockerHub](https://hub.docker.com/)
- [x] Securing Code, Dependencies, Containers with [Snyk](https://snyk.io/)
- [x] Enhance [CircleCI](https://circleci.com/) workflows with [SonarCloud](https://sonarcloud.io/) continuous Code Quality and Code Security analysis
- [x] Integrate [JaCoCo](https://www.eclemma.org/jacoco/) to Generate & Aggregate Coverage Reports in [CircleCI](https://circleci.com/) for [SonarCloud](https://sonarcloud.io/) Analysis

# Next Features : Roadmap

- [ ] Design and Develop a Graph Service with [Spring Boot](https://spring.io/projects/spring-boot) and [MongoDB](https://www.mongodb.com/) | Build Faster. Build Smarter.  
- [ ] Integrate Caching ( [Spring Data Redis](https://spring.io/projects/spring-data-redis) ) with [Redis](https://redis.io/)
- [ ] Design [Load Balancing with NGINX and Consul Template](https://learn.hashicorp.com/tutorials/consul/load-balancing-nginx?in=consul/integrations)
- [ ] Design, Implement & Integrate [CQRS](https://www.confluent.io/blog/event-sourcing-cqrs-stream-processing-apache-kafka-whats-connection/) with [Kafka](https://kafka.apache.org/)
- [ ] Integrate [Graph Visualization](https://github.com/lyes-s/graph-visualization)
- [ ] Secure Network Device Inventory & Graph Services with [Keycloak](https://www.keycloak.org/)
- [ ] Centralize Tracing with [ELK Stack](https://www.elastic.co/elastic-stack/)
- [ ] Deploy to [Kubernetes](https://kubernetes.io/)

# Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

[Please make sure to update tests as appropriate](https://github.com/lyes-s/network-device-inventory/wiki/Application-Test-Suite-with-JUnit-5-&-Mockito-%F0%9F%8D%B8).

# License

[MIT](https://github.com/lyes-s/network-device-inventory/blob/master/LICENSE.md)
