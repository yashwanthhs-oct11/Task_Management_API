# TaskAPI

TaskAPI is a RESTful web application for task management. It allows users to manage tasks, teams, and user authentication with JWT-based authentication. This API is built with Spring Boot and MongoDB as the database.

## Features

- **User Authentication**: Login functionality using JWT tokens.
- **Task Management**: Create, retrieve, update, delete, and manage tasks.
- **Team Management**: Create and manage teams and their members.
- **User Management**: Create and manage user information.
- **Filtering and Search**: Filter tasks by priority, collaborators, dependencies, overdue status, and due date.

## Technologies Used

- **Java**: Programming language.
- **Spring Boot**: Framework for creating RESTful APIs.
- **Spring Security**: For JWT-based authentication.
- **MongoDB**: NoSQL database for data storage.
- **JWT**: JSON Web Tokens for securing endpoints.

## Project Structure

- **controller**: Contains RESTful API controllers.
- **model**: Contains model classes representing entities such as `Task`, `Team`, `User`, and authentication requests/responses.
- **service**: Contains service classes that handle the business logic.
- **util**: Contains utility classes, including JWT utility.

## Endpoints

### Authentication
- **POST /api/auth/login**: Authenticate a user and generate a JWT.

### Task Management
- **GET /api/tasks**: Retrieve all tasks.
- **GET /api/tasks/{id}**: Retrieve a task by ID.
- **POST /api/tasks**: Create a new task.
- **PUT /api/tasks/{id}**: Update a task.
- **DELETE /api/tasks/{id}**: Delete a task.
- **GET /api/tasks/collaborators/{userId}**: Retrieve tasks by collaborator.
- **GET /api/tasks/dependencies/{taskId}**: Retrieve tasks by dependency.
- **GET /api/tasks/overdue**: Retrieve overdue tasks.
- **GET /api/tasks/priority/{priority}**: Retrieve tasks by priority.
- **GET /api/tasks/due-soon**: Retrieve tasks due within the next day.
- **PUT /api/tasks/{id}/complete**: Mark a task as complete.
- **PUT /api/tasks/{id}/incomplete**: Mark a task as incomplete.

### Team Management
- **GET /api/teams**: Retrieve all teams.
- **GET /api/teams/{id}**: Retrieve a team by ID.
- **POST /api/teams**: Create a new team.
- **PUT /api/teams/{id}**: Update a team.
- **DELETE /api/teams/{id}**: Delete a team.

### User Management
- **GET /api/users**: Retrieve all users.
- **GET /api/users/{id}**: Retrieve a user by ID.
- **POST /api/users**: Create a new user.
- **PUT /api/users/{id}**: Update a user.
- **DELETE /api/users/{id}**: Delete a user.
- **GET /api/users/username/{username}**: Retrieve a user by username.

## Models

- **User**: Represents a user with fields such as `username`, `password`, and `role`.
- **Task**: Represents a task with fields for `title`, `description`, `priority`, `due date`, `collaborators`, and `dependencies`.
- **Team**: Represents a team with fields for `name` and `member IDs`.
- **AuthenticationRequest & AuthenticationResponse**: Represent login requests and responses.

## Setup

### Prerequisites
- **Java 11+**
- **Maven**
- **MongoDB** 

4. The API will be accessible at `http://localhost:8080`.

### Configuration
The MongoDB connection and JWT secret should be set in `application.properties`.

Example configuration:
```properties
# MongoDB
spring.data.mongodb.uri=mongodb://localhost:27017/databaseName

# JWT
jwt.secret=yashwanth-secret-key
```
