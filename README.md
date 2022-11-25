
# Process Solution Template for Camunda Platform 8 using Java and Spring Boot

This repository contains a Java application template for Camunda Platform 8 using Spring Boot.

- [Documentation](https://docs.camunda.io)
- [Camunda Platform SaaS](https://camunda.io)
- [Getting Started Guide](https://github.com/camunda/camunda-platform-get-started)
- [Releases](https://github.com/camunda/camunda-platform/releases)
- [Helm Charts](https://helm.camunda.io/)
- [Zeebe Workflow Engine](https://github.com/camunda/zeebe)
- [Contact](https://docs.camunda.io/contact/)

## Using the Spring Boot application

The application requires a running Zeebe engine.
You can run Zeebe locally using the instructions below for Docker Compose
or have a look at our
[recommended deployment options for Camunda Platform](https://docs.camunda.io/docs/self-managed/platform-deployment/#deployment-recommendation.).



## How to run the environment and application
### Start Camunda 8
    cd /directory/to/camunda8-platform
    docker compose -f docker-compose-core.yaml up -d

### Start Postgres
    cd ${poc-bearingpoint}/docker/postgres
    docker compose up -d

### Start the application
    JDK 17 installieren
    MVN installieren
    in VisualCode (im Terminal): 
    mvn clean install
    ProcessApplication ==> Run
    spring-boot:run

### Start a process instance (via Postman)
   POST http://localhost:8080/process/startMortgage
   {
    "firstname":"Peter",
    "lastname": "Pan",
    "emailAdress": "peter.pan@mail.com",
    "zipcode": "54321",
    "city": "Nimmerland",
    "birthdate": "1998-04-28"
   }

### Start a process instance (via Modeler)
   {
    "firstname":"Peter",
    "lastname": "Pan",
    "emailAdress": "peter.pan@mail.com",
    "zipcode": "54321",
    "city": "Nimmerland",
    "birthdate": "1998-04-28"
   }

### Access to the web apps
   Operate
   http://localhost:8081

   Tasklist
   http://localhost:8082