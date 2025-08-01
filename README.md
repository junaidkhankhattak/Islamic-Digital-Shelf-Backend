# Islamic Digital Shelf – Backend

This is the backend for the **Islamic Digital Shelf** project, built using **Spring Boot** and **MySQL**.  
It provides RESTful APIs for managing books, authors, users, and orders.

## 🚀 Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Spring Security (if used)
- REST APIs

## 🗃️ Database

Database: `library_db`  
Tables: `books`, `authors`, `users`, `orders`, etc.
## 📁 Project Structure
/islamic_digital_shelf
│
├── /src/main/java/com/fyp/islamic_digital_shelf/
│ ├── controllers/
│ ├── models/
│ ├── repositories/
│ ├── services/
│ └── IslamicDigitalShelfApplication.java
│
├── application.properties
└── README.md

## 🔧 Features

- Add/view/update/delete Islamic books
- Author management
- Order management
- User registration and login (optional)
- Integration with Google Drive for file links

## 🔌 API Endpoints

- `GET /api/books`
- `POST /api/books`
- `GET /api/authors`
- `POST /api/orders`
- ...

## 🧪 Running the App

Make sure MySQL is running and configured in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/library_db
spring.datasource.username=root
spring.datasource.password=your_password
./mvnw spring-boot:run
