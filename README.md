Example Project - README
English:

Example Project
This is a Spring Boot application that demonstrates a simple system for managing todos and users.

Features
Todo Management:

Create, update, and complete todos.
Associate todos with users.
User Management:

Register new users.
Retrieve user details.
Delete users.
Technologies
Spring Boot: For the main application framework.
MySQL: For the database.
JPA / Hibernate: For ORM and database interactions.
Setup
Clone the Repository

bash
Копировать код
git clone <repository-url>
cd example-project
Configure the Application

Update src/main/resources/application.properties with your database settings.

properties
Копировать код
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/exampleforspring?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=Whocareswhoami708
Build and Run

bash
Копировать код
./mvnw spring-boot:run
Access the Application

Open your web browser and go to http://localhost:8080 to access the application.

Docker Setup
To run this application using Docker, you need to configure and start both the application and the PostgreSQL database. Here’s how:

Create a Dockerfile

Create a file named Dockerfile in the root of your project with the following content:

Dockerfile
Копировать код
FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/example-project.jar example-project.jar
ENTRYPOINT ["java","-jar","/example-project.jar"]
Build the Docker Image

bash
Копировать код
docker build -t example-project .
Configure Docker Compose

Create a file named docker-compose.yml in the root of your project with the following content:

yaml
Копировать код
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
Start the Services

bash
Копировать код
docker-compose up
This will start both the PostgreSQL database and your Spring Boot application.

API Endpoints
Users
POST /users: Register a new user.
GET /users: Get user details by ID.
DELETE /users/{id}: Delete a user by ID.
Todos
POST /todos: Create a new todo.
PUT /todos: Complete a todo by ID.
Exceptions
UserAlreadyExistException: Thrown when trying to register a user that already exists.
UserNotFoundException: Thrown when trying to retrieve a user that does not exist.
License
This project is licensed under the MIT License - see the LICENSE file for details.

Русский:

Проект Example
Это приложение на Spring Boot, демонстрирующее простую систему управления задачами и пользователями.

Функции
Управление задачами:

Создание, обновление и завершение задач.
Ассоциация задач с пользователями.
Управление пользователями:

Регистрация новых пользователей.
Получение информации о пользователе.
Удаление пользователей.
Технологии
Spring Boot: Основная платформа приложения.
MySQL: Для базы данных.
JPA / Hibernate: Для ORM и взаимодействия с базой данных.
Настройка
Клонировать Репозиторий

bash
Копировать код
git clone <repository-url>
cd example-project
Настройте Приложение

Обновите src/main/resources/application.properties с вашими настройками базы данных.

properties
Копировать код
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/exampleforspring?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=Whocareswhoami708
Сборка и Запуск

bash
Копировать код
./mvnw spring-boot:run
Доступ к Приложению

Откройте ваш веб-браузер и перейдите по адресу http://localhost:8080, чтобы получить доступ к приложению.

Docker Настройка
Для запуска этого приложения с использованием Docker необходимо настроить и запустить как приложение, так и базу данных PostgreSQL. Вот как это сделать:

Создайте Dockerfile

Создайте файл с именем Dockerfile в корне вашего проекта со следующим содержимым:

Dockerfile
Копировать код
FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/example-project.jar example-project.jar
ENTRYPOINT ["java","-jar","/example-project.jar"]
Постройте Docker Образ

bash
Копировать код
docker build -t example-project .
Настройте Docker Compose

Создайте файл с именем docker-compose.yml в корне вашего проекта со следующим содержимым:

yaml
Копировать код
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
Запустите Сервисы

bash
Копировать код
docker-compose up
Это запустит как базу данных PostgreSQL, так и ваше приложение Spring Boot.

API Эндпоинты
Пользователи
POST /users: Регистрация нового пользователя.
GET /users: Получение информации о пользователе по ID.
DELETE /users/{id}: Удаление пользователя по ID.
Задачи
POST /todos: Создание новой задачи.
PUT /todos: Завершение задачи по ID.
Исключения
UserAlreadyExistException: Выбрасывается при попытке зарегистрировать пользователя, который уже существует.
UserNotFoundException: Выбрасывается при попытке получить информацию о пользователе, который не существует.