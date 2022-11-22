[![Community Extension](https://img.shields.io/badge/Community%20Extension-An%20open%20source%20community%20maintained%20project-FF4700)](https://github.com/camunda-community-hub/community)
![Compatible with: Camunda Platform 8](https://img.shields.io/badge/Compatible%20with-Camunda%20Platform%208-0072Ce)
[![](https://img.shields.io/badge/Lifecycle-Incubating-blue)](https://github.com/Camunda-Community-Hub/community/blob/main/extension-lifecycle.md#incubating-)

# Process Solution Template for Camunda Platform 8 using Java and Spring Boot

This repository contains a Java application template for Camunda Platform 8 using Spring Boot
and a [docker-compose.yaml](docker-compose.yaml) file for local development. For production setups we recommend to use our [helm charts](https://docs.camunda.io/docs/self-managed/platform-deployment/kubernetes-helm/).

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

Run the application via
```
./mvnw spring-boot:run
```



## Using this template

Fork [this repository](https://github.com/camunda-community-hub/camunda-process-solution-template) on GitHub
and rename/refactor the following artifacts:

* `groupId`, `artifactId`, `name`, and `description` in [pom.xml](pom.xml)
* `process/@id` and `process/@name` in [src/main/resources/models/camunda-process.bpmn](src/main/resources/models/camunda-process.bpmn)
* `ProcessConstansts#BPMN_PROCESS_ID` in [src/main/java/org/example/camunda/process/solution/ProcessConstants.java](src/main/java/org/example/camunda/process/solution/ProcessConstants.java)
* Java package name, e.g. `org.example.camunda.process.solution.*`

By forking this project, you can stay connected to improvements that we do to this template and simply pull updates into your fork, e.g. by using GitHub's Web UI or the following commands:

```sh
git remote add upstream git@github.com:camunda-community-hub/camunda-8-process-solution-template.git
git pull upstream main
git push
```