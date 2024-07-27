# Example Project

Example Project is a Spring Boot application for managing todos and users. This application includes functionalities such as creating, updating, and deleting todos, as well as user registration and management.

## Features

- **Todo Management**:
  - Create, update, and complete todos.
  - Associate todos with users.

- **User Management**:
  - Register new users.
  - Retrieve user details.
  - Delete users.

## Requirements

- Java 17 or higher
- Maven
- MySQL or PostgreSQL

## Installation

1. **Clone the repository**:
    ```sh
    git clone https://github.com/<your-github-username>/example-project.git
    cd example-project
    ```

2. **Configure the application**:
    Update `src/main/resources/application.properties` with your database settings.
    ```properties
    spring.jpa.hibernate.ddl-auto=update
    spring.datasource.url=jdbc:mysql://localhost:3306/exampleforspring?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
    spring.datasource.username=root
    spring.datasource.password=Whocareswhoami708
    ```

3. **Build and run the application**:
    ```sh
    ./mvnw spring-boot:run
    ```

4. **Access the application**:
    Open your browser and go to `http://localhost:8080`.

## Docker Setup

To run this application using Docker:

1. **Create a Dockerfile**:
    ```Dockerfile
    FROM openjdk:17-jdk-slim
    VOLUME /tmp
    COPY target/example-project.jar example-project.jar
    ENTRYPOINT ["java","-jar","/example-project.jar"]
    ```

2. **Build the Docker image**:
    ```sh
    docker build -t example-project .
    ```

3. **Configure Docker Compose**:
    Create a file named `docker-compose.yml`:
    ```yaml
    version: '3.8'

    services:
      db:
        container_name: postgres
        image: postgres
        environment:
          POSTGRES_USER: seisen
          POSTGRES_PASSWORD: Whocares?Whoami?
          PGDATA: /data/postgres
        volumes:
          - db:/data/postgres
        ports:
          - "5332:5432"
        networks:
          - db
        restart: unless-stopped

      app:
        image: example-project
        ports:
          - "8080:8080"
        depends_on:
          - db
        networks:
          - db

    networks:
      db:
        driver: bridge

    volumes:
      db:
    ```

4. **Start the services**:
    ```sh
    docker-compose up
    ```

## API Endpoints

### Users

- **POST /users**: Register a new user.
- **GET /users**: Retrieve user details by ID.
- **DELETE /users/{id}**: Delete a user by ID.

### Todos

- **POST /todos**: Create a new todo.
- **PUT /todos**: Update the completion status of a todo by ID.

## Exceptions

- **UserAlreadyExistException**: Thrown when trying to register a user that already exists.
- **UserNotFoundException**: Thrown when trying to retrieve a user that does not exist.

## Contributing

Feel free to submit issues and pull requests. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.






## Русская версия

# Пример проекта

Пример проекта — это приложение на Spring Boot для управления задачами (todos) и пользователями. В этом приложении реализованы функции создания, обновления и удаления задач, а также регистрация и управление пользователями.

## Функционал

- **Управление задачами**:
  - Создание, обновление и выполнение задач.
  - Связывание задач с пользователями.

- **Управление пользователями**:
  - Регистрация новых пользователей.
  - Получение информации о пользователе.
  - Удаление пользователей.

## Требования

- Java 17 или выше
- Maven
- MySQL или PostgreSQL

## Установка

1. **Клонируйте репозиторий**:
    ```sh
    git clone https://github.com/<ваше-имя-пользователя-на-github>/example-project.git
    cd example-project
    ```

2. **Настройте приложение**:
    Обновите `src/main/resources/application.properties` с вашими настройками базы данных.
    ```properties
    spring.jpa.hibernate.ddl-auto=update
    spring.datasource.url=jdbc:mysql://localhost:3306/exampleforspring?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
    spring.datasource.username=root
    spring.datasource.password=Whocareswhoami708
    ```

3. **Соберите и запустите приложение**:
    ```sh
    ./mvnw spring-boot:run
    ```

4. **Доступ к приложению**:
    Откройте браузер и перейдите по адресу `http://localhost:8080`.

## Настройка Docker

Чтобы запустить это приложение с помощью Docker:

1. **Создайте Dockerfile**:
    ```Dockerfile
    FROM openjdk:17-jdk-slim
    VOLUME /tmp
    COPY target/example-project.jar example-project.jar
    ENTRYPOINT ["java","-jar","/example-project.jar"]
    ```

2. **Соберите Docker-образ**:
    ```sh
    docker build -t example-project .
    ```

3. **Настройте Docker Compose**:
    Создайте файл `docker-compose.yml`:
    ```yaml
    version: '3.8'

    services:
      db:
        container_name: postgres
        image: postgres
        environment:
          POSTGRES_USER: seisen
          POSTGRES_PASSWORD: Whocares?Whoami?
          PGDATA: /data/postgres
        volumes:
          - db:/data/postgres
        ports:
          - "5332:5432"
        networks:
          - db
        restart: unless-stopped

      app:
        image: example-project
        ports:
          - "8080:8080"
        depends_on:
          - db
        networks:
          - db

    networks:
      db:
        driver: bridge

    volumes:
      db:
    ```

4. **Запустите сервисы**:
    ```sh
    docker-compose up
    ```

## API Эндпоинты

### Пользователи

- **POST /users**: Регистрация нового пользователя.
- **GET /users**: Получение информации о пользователе по ID.
- **DELETE /users/{id}**: Удаление пользователя по ID.

### Задачи

- **POST /todos**: Создание новой задачи.
- **PUT /todos**: Обновление статуса выполнения задачи по ID.

## Исключения

- **UserAlreadyExistException**: Исключение, выбрасываемое при попытке зарегистрировать пользователя, который уже существует.
- **UserNotFoundException**: Исключение, выбрасываемое при попытке получить информацию о пользователе, который не существует.

## Участие

Не стесняйтесь подавать проблемы и запросы на изменения. Для крупных изменений, пожалуйста, сначала откройте проблему, чтобы обсудить желаемые изменения.

## Лицензия

Этот проект лицензируется по лицензии MIT. См. файл [LICENSE](LICENSE) для получения подробностей.
