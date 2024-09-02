## License

[Creative Commons Attribution-NonCommercial-NoDerivs 4.0 International License][cc-by-nc-nd].

[![CC BY-NC-ND 4.0][cc-by-nc-nd-image]][cc-by-nc-nd]

[cc-by-nc-nd]: http://creativecommons.org/licenses/by-nc-nd/4.0/
[cc-by-nc-nd-image]: https://licensebuttons.net/l/by-nc-nd/4.0/88x31.png
[cc-by-nc-nd-shield]: https://img.shields.io/badge/License-CC%20BY--NC--ND%204.0-lightgrey.svg

# GitHub Badges

![GitHub Repo stars](https://img.shields.io/github/stars/lyes-sefiane/network-device-inventory?style=social)
![GitHub top language](https://img.shields.io/github/languages/top/lyes-sefiane/network-device-inventory)
![GitHub release (latest by date)](https://img.shields.io/github/v/release/lyes-sefiane/network-device-inventory)
![GitHub Release Date](https://img.shields.io/github/release-date/lyes-sefiane/network-device-inventory)
![GitHub commit activity (branch)](https://img.shields.io/github/commit-activity/y/lyes-sefiane/network-device-inventory/master)


# Network Device Microservices

### Wiki

* [lyes-sefiane/network-device-microservices/wiki](https://github.com/lyes-sefiane/network-device-inventory/wiki)

## Network Device Inventory Service

### Wiki

* [lyes-sefiane/network-device-inventory-service](https://github.com/lyes-sefiane/network-device-inventory/tree/master/network-device-inventory-service)

### OpenAPI/Swagger

* [lyes-sefiane/swaggerhub.com/apis-docs/lyes-sefiane/network-device_inventory/1.0](https://app.swaggerhub.com/apis-docs/lyes-sefiane/network-device_inventory/1.0)

### Docker Compose

* Regarding the network device inventory service local dev/test, please replace "expose" by "port" in the manifest so that the endpoints will be reachable outside the docker.  

```
cd docker-compose/

docker-compose -f service-registry.yml -f network-device-inventory.yml -f --env-file .env  up -d
```

![Image](https://raw.githubusercontent.com/wiki/lyes-sefiane/network-device-inventory/images/inventory-restful-web-service-v3.PNG)

## Monitoring

### Wiki

* [lyes-sefiane/network-device-inventory/monitoring](https://github.com/lyes-sefiane/network-device-inventory/wiki/Monitoring)

### Docker Compose

```
cd docker-compose/

docker-compose -f service-registry.yml -f network-device-inventory.yml -f monitoring.yml -f gateway.yml --env-file .env  up -d
```

![Image](https://raw.githubusercontent.com/wiki/lyes-sefiane/network-device-inventory/images/monitoring-system-design-v2.PNG)

## Snyk: 'So Now You Know'

### Wiki

* [lyes-sefiane/network-device-inventory/Snyk-Securing-Code-Dependencies-Containers-and-Infrastructure-as-Code](https://github.com/lyes-sefiane/network-device-inventory/wiki/Snyk-Securing-Code,-Dependencies,-Containers-and-Infrastructure-as-Code)

![Image](https://raw.githubusercontent.com/wiki/lyes-sefiane/network-device-inventory/images/CircleCiBuild.PNG)


## SonarCloud: Code Quality and Code Security

### Wiki

* [lyes-sefiane/network-device-inventory/SonarCloud-Code-Quality-and-Code-Security](https://github.com/lyes-sefiane/network-device-inventory/wiki/SonarCloud-Code-Quality-and-Code-Security)

![Image](https://raw.githubusercontent.com/wiki/lyes-sefiane/network-device-inventory/images/sonarcloud-v3.PNG)


## CircleCI: Continuous Integration and Delivery

### Wiki

* [lyes-sefiane/network-device-inventory/CircleCI-Continuous-Integration-and-Delivery](https://github.com/lyes-sefiane/network-device-inventory/wiki/CircleCI-Continuous-Integration-and-Delivery)

![Image](https://raw.githubusercontent.com/wiki/lyes-sefiane/network-device-inventory/images/release-workflow-v7.PNG)

# Requirements
```
1. Java 11.x.y

2. Maven 3.x.y

3. Docker 3.x.y
```

# Git Clone
```
https://github.com/lyes-sefiane/network-device-inventory.git
```

# Completed Features

- [x] Build Docker Images In a [CircleCI](https://circleci.com/) Pipeline & Push them to [DockerHub](https://hub.docker.com/)
- [x] Securing Code, Dependencies, Containers with [Snyk](https://snyk.io/)
- [x] Enhance [CircleCI](https://circleci.com/) workflows with [SonarCloud](https://sonarcloud.io/) continuous Code Quality and Code Security analysis
- [x] Integrate [JaCoCo](https://www.eclemma.org/jacoco/) to Generate & Aggregate Coverage Reports in [CircleCI](https://circleci.com/) for [SonarCloud](https://sonarcloud.io/) Analysis

# Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

[Please make sure to update tests as appropriate](https://github.com/lyes-s/network-device-inventory/wiki/Application-Test-Suite-with-JUnit-5-&-Mockito-%F0%9F%8D%B8).
