Maap-Admin-app

From Docker image at centos

- To build "docker build -t spring-boot-docker ." with dot
- To running "docker run -d -p 8080:8080 spring-boot-docker"

from maven command line profile local  
mvnw spring-boot:run -Dmaven.test.skip=true -Dspring-boot.run.profiles=local

#### Api docs:

- http://localhost:8080/maap-admin/v2/api-docs

#### Swagger:

- http://localhost:8080/maap-admin/swagger-ui.html#/

#### Sonnar:

- https://sonarcloud.io/dashboard?id=maap-admin

#### Cicle CI:

- https://app.circleci.com/pipelines/bitbucket/???