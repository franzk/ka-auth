# Keycloak with Spring Boot simple example

## Installation
- Clone this repo

- In ./run folder
  - $ bash install.sh
  - $ bash run.sh

- Open the Keycloak Admin : http://localhost:8180/admin
  - create a Realm called franz
  - create a client called springboot-keycloak (Client type = OpenID Connect)
  - create a role (Realm roles >> create role)
  - create an user with this role. Don't forget to create a password in the Credentials Tab.

- Run the Spring Boot app

- check : http://localhost:8080/user
