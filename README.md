# 📘 Quiz System Backend (Spring Boot + MySQL + Railway)

A production-ready REST API for a Quiz Management System built using **Spring Boot**, **Spring Security (JWT)**, and **MySQL**, deployed on **Railway**.

This backend supports authentication, role-based access control, quiz creation, quiz attempts, and result submission.

---

## 🚀 Live Deployment

**Backend URL:**
```
https://quiz-system-backend-production.up.railway.app
```

**Database:** Railway Managed MySQL (Docker-based)

---

# 🛠 Tech Stack

### Backend
- Java 21
- Spring Boot 4
- Spring Security
- JWT Authentication
- Spring Data JPA (Hibernate)
- BCrypt Password Encoder
- MySQL Connector

### Database
- MySQL 9.4
- Railway Persistent Volume

### Deployment
- Railway Cloud Platform
- Dockerized MySQL
- Environment Variable Configuration

### Testing
- Postman

---

# 🔐 Features

## 1️⃣ Authentication & Authorization
- User Registration
- User Login
- JWT Token Generation
- Stateless Authentication
- Password encryption using BCrypt

---

## 2️⃣ Role-Based Access Control

| Role     | Access |
|----------|--------|
| ADMIN    | Create & Manage Quizzes |
| STUDENT  | View & Submit Quizzes |
| PUBLIC   | Register & Login |

### Security Routes Configuration

- `/api/auth/**` → Public
- `/api/admin/**` → ADMIN only
- `/api/student/**` → STUDENT only

---

## 3️⃣ Quiz Management APIs

- Create Quiz (Admin)
- Get All Quizzes
- Get Quiz By ID
- Submit Quiz
- Store Quiz Results

---

# 📦 API Endpoints

## 🔓 Authentication APIs

### ➤ Register
```
POST /api/auth/register
```

Request Body:
```json
{
  "username": "user",
  "password": "12345",
  "role": "STUDENT"
}
```

---

### ➤ Login
```
POST /api/auth/login
```

Response:
```json
{
  "token": "jwt_token_here"
}
```

---

## 👨‍🏫 Admin APIs (Requires ADMIN Role)

```
POST   /api/admin/create
GET    /api/admin/quizzes
GET    /api/admin/quiz/{id}
```

Header Required:
```
Authorization: Bearer <JWT_TOKEN>
```

---

## 👨‍🎓 Student APIs (Requires STUDENT Role)

```
GET    /api/student/quizzes
POST   /api/student/submit
```

Header Required:
```
Authorization: Bearer <JWT_TOKEN>
```

---

# 🗄 Database Configuration (Railway Production)

Environment Variables Used:

```
SPRING_DATASOURCE_URL
SPRING_DATASOURCE_USERNAME
SPRING_DATASOURCE_PASSWORD
```

Example JDBC URL format:

```
jdbc:mysql://${MYSQLHOST}:${MYSQLPORT}/${MYSQLDATABASE}?useSSL=false&allowPublicKeyRetrieval=true
```

---

# 🏗 Project Structure

```
quiz-system
│
├── config
│   └── SecurityConfig.java
│
├── controller
│   ├── AuthController.java
│   ├── AdminController.java
│   └── StudentController.java
│
├── service
│
├── repository
│
├── entity
│
├── security
│   └── JwtAuthFilter.java
│
└── QuizSystemApplication.java
```

---

# 🔐 Security Architecture

1. User logs in
2. JWT token is generated
3. Token sent in request header
4. JwtAuthFilter validates token
5. Role-based access is enforced

Authentication is **stateless** (no sessions stored).

---

# 🌍 Deployment Architecture

```
Client (Postman / Frontend)
            ↓
Railway Backend (Spring Boot)
            ↓
Railway MySQL (Docker Container)
```

- Backend and database deployed as separate services
- MySQL uses persistent storage
- Environment-based configuration for production
- Secure cloud hosting via Railway

---

# 🧪 How to Test Using Postman

1. Register a user
2. Login and copy JWT token
3. Add header:
   ```
   Authorization: Bearer <TOKEN>
   ```
4. Access protected endpoints

---

# ⚙️ How to Run Locally

## 1️⃣ Clone Repository
```
git clone <your-repository-url>
cd quiz-system
```

## 2️⃣ Configure Local Database (application.yml)

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/quizdb
    username: root
    password: root
```

## 3️⃣ Run Application
```
mvn spring-boot:run
```

---

# 👩‍💻 Author

**Anchal Shukla**