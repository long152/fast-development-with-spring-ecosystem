# Fast Development with Spring Ecosystem
This is a demo project to show how we can leverage the spring ecosystem
to develop REST API quickly.

Presentation: [PDF](fast-development-with-spring-ecosystem.pdf)

## How to start application
### With MariaDB
```sh
./gradlew bootRun --args='--spring.profiles.active=mariadb'
```

### With H2 DB
```sh
./gradlew bootRun --args='--spring.profiles.active=h2'
```
## How to start fake ISBN system server
1. Install [JSON Server](https://github.com/typicode/json-server).
    ```sh
    npm install -g json-server
    ```
2. Start a server
    ```sh
   json-server --watch src/main/resources/static/db.json
   ```