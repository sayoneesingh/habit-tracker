# 🧠 Habit Tracker Backend API

A backend application to manage daily habits, built with **Spring Boot** and **PostgreSQL**. It provides a RESTful API to create, update, delete, and retrieve habits.

---

## 📌 Features

- RESTful CRUD operations for Habit entities
- Validation using DTOs
- Global exception handling
- PostgreSQL integration
- Postman collection for easy testing

---

## 🛠 Tech Stack

- Java 17
- Spring Boot 3.5.4
- Spring Data JPA
- PostgreSQL
- Lombok
- Gradle

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- PostgreSQL installed and running
- IntelliJ or any IDE
- Gradle

### Clone and Run

```bash
git clone https://github.com/sayoneesingh/habit-tracker.git
cd habit-tracker
```

Update `application.properties` with your PostgreSQL config:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/habit_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

Then run:

```bash
./gradlew bootRun
```

---

## 🔗 API Endpoints

All endpoints are prefixed with `/api/habits`.

### ✅ Get All Habits
- `GET /api/habits`

### 🔍 Get Habit by ID
- `GET /api/habits/{id}`

### ➕ Create a Habit
- `POST /api/habits`

**Request Body:**
```json
{
  "name": "Morning Run",
  "description": "Run 3km every morning",
  "active": true
}
```

### ✏️ Update a Habit
- `PUT /api/habits/{id}`

**Request Body:**
```json
{
  "name": "Evening Walk",
  "description": "Walk 30 minutes every evening",
  "active": false
}
```

### ❌ Delete a Habit
- `DELETE /api/habits/{id}`

---

## 🧪 Postman Collection

You can test the APIs using Postman. [/postman/Habit%20Tracker%20Application.postman_collection.json]

---

## ⚠️ Error Handling

Global exceptions are handled with clear messages and proper HTTP status codes:

| Exception            | HTTP Status     |
|----------------------|------------------|
| Resource Not Found   | 404 Not Found    |
| Validation Errors    | 400 Bad Request  |
| Server Error         | 500 Internal Server Error |

---

## 📂 Project Structure

```bash
habit-tracker/
├── controller/
│   └── HabitController.java
├── dto/
│   └── HabitRequest.java
├── exception/
│   ├── GlobalExceptionHandler.java
│   └── ResourceNotFoundException.java
├── model/
│   └── Habit.java
├── repository/
│   └── HabitRepository.java
├── service/
│   └── HabitService.java
├── HabitTrackerApplication.java
└── application.properties
```

---

## 📌 Future Enhancements

- User authentication (JWT-based)
- Habit completion tracking
- Reminders or notifications

---

## 👤 Author

Sayonee Singh Bhati
• [LinkedIn](https://www.linkedin.com/in/sayonee-singh-bhati/) 
• [GitHub](https://github.com/sayoneesingh)
