# Network Device Inventory Microservices
[![CircleCI](https://circleci.com/gh/lyes-s/network-device-inventory/tree/master.svg?style=shield)](https://circleci.com/gh/lyes-s/network-device-inventory/tree/master)
![Snyk Vulnerabilities for GitHub Repo](https://img.shields.io/snyk/vulnerabilities/github/lyes-s/network-device-inventory)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=lyes-s_network-device-inventory&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=lyes-s_network-device-inventory)
![GitHub top language](https://img.shields.io/github/languages/top/lyes-s/network-device-inventory)
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

## Monitoring

* [lyes-s/network-device-inventory/monitoring/](https://github.com/lyes-s/network-device-inventory/wiki/Monitoring)

```
COMPOSE_PROFILES=inventory,monitoring docker-compose --env-file .env  up -d
```

![Image](https://raw.githubusercontent.com/wiki/lyes-s/network-device-inventory/images/monitoring-system-design-v2.PNG)

## CircleCI: Continuous Integration and Delivery Documentation

* [lyes-s/network-device-inventory/CircleCI-Continuous-Integration-and-Delivery/](https://github.com/lyes-s/network-device-inventory/wiki/CircleCI-Continuous-Integration-and-Delivery)

![Image](https://raw.githubusercontent.com/wiki/lyes-s/network-device-inventory/images/release-workflow-v4.PNG)


## Snyk: 'So Now You Know'

### Securing Code, Dependencies in GitHub

![Image](https://raw.githubusercontent.com/wiki/lyes-s/network-device-inventory/images/GithubScan.PNG)

### Securing Code, Dependencies and Containers in CircleCI Pipelines

Note : 

* Failed workflow(s) will not be displayed in Snyk (due to build/test failure or vulnerabilities discovery). 

In the screenshot below Snyk found 2 issues (02 active critical vulnerabilities for NGINX). The CI fail.  

```
Run Snyk

Testing ********/*************:latest...

✗ Critical severity vulnerability found in pcre2/libpcre2-8-0
  Description: Out-of-bounds Read
  Info: https://snyk.io/vuln/SNYK-DEBIAN11-PCRE2-2808697
  Introduced through: meta-common-packages@meta
  From: meta-common-packages@meta > pcre2/libpcre2-8-0@10.36-2

✗ Critical severity vulnerability found in pcre2/libpcre2-8-0
  Description: Out-of-bounds Read
  Info: https://snyk.io/vuln/SNYK-DEBIAN11-PCRE2-2808704
  Introduced through: meta-common-packages@meta
  From: meta-common-packages@meta > pcre2/libpcre2-8-0@10.36-2



Organization:      lyes-s
Package manager:   deb
Project name:      docker-image|********/*************
Docker image:      ********/*************:latest
Platform:          linux/amd64
Base image:        nginx:1.22.0
Licenses:          enabled

Tested 143 dependencies for known issues, found 2 issues.

According to our scan, you are currently using the most secure version of the selected base image



Exited with code exit status 1

CircleCI received exit code 1
```

![Image](https://raw.githubusercontent.com/wiki/lyes-s/network-device-inventory/images/CircleCiBuild.PNG)


## SonarCloud: Code Quality and Code Security

* [lyes-s/network-device-inventory/SonarCloud-Code-Quality-and-Code-Security/](https://github.com/lyes-s/network-device-inventory/wiki/SonarCloud-Code-Quality-and-Code-Security)

![Image](https://raw.githubusercontent.com/wiki/lyes-s/network-device-inventory/images/sonarcloud-v2.PNG)


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

## Completed Features

- [x] Build Docker Images In a [CircleCI](https://circleci.com/) Pipeline & Push them to [DockerHub](https://hub.docker.com/)
- [x] Securing Code, Dependencies, Containers with [Snyk](https://snyk.io/)
- [x] Enhance [CircleCI](https://circleci.com/) workflows with [SonarCloud](https://sonarcloud.io/) continuous Code Quality and Code Security analysis

## Next Features : Roadmap

- [ ] Design and Develop a Graph Service with [GO](https://go.dev/)
- [ ] Integrate & Implement [CQRS](https://www.confluent.io/blog/event-sourcing-cqrs-stream-processing-apache-kafka-whats-connection/) with [Kafka](https://kafka.apache.org/)
- [ ] Integrate [Graph Visualization](https://github.com/lyes-s/graph-visualization)
- [ ] Secure Network Device Inventory & Graph Services with [Keycloak](https://www.keycloak.org/)
- [ ] Centralize Tracing with [ELK Stack](https://www.elastic.co/elastic-stack/)
- [ ] Deploy to [Kubernetes](https://kubernetes.io/)

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

[Please make sure to update tests as appropriate](https://github.com/lyes-s/network-device-inventory/wiki/Application-Test-Suite-with-JUnit-5-&-Mockito-%F0%9F%8D%B8).

## License

[MIT](https://github.com/lyes-s/network-device-inventory/blob/master/LICENSE.md)
