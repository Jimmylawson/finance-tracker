# 💰 Personal Finance Tracker

A Spring Boot-based backend API for tracking users' budgets and transactions. This RESTful service helps users monitor their spending, categorize expenses, and manage budgets effectively.

## ✨ Features

- 📦 **User Management**
    - Create and retrieve users (basic for now)
    - Endpoint: `GET /api/v1/user`

- 🧾 **Transaction Management**
    - Create, update, delete, and list transactions
    - Filter transactions by user ID
    - DTO-layer mapping with MapStruct

- 💸 **Budget Management**
    - Add, update, delete, and retrieve budgets
    - Associate budgets with specific users
    - Auto-mapped with DTOs

- 🔄 **DTO ↔ Entity Mapping**
    - Handled with MapStruct (`@Mapper(componentModel = "spring")`)

- 🔐 **Validation**
    - Spring Boot validation annotations on DTOs
    - Custom error handling with `@ExceptionHandler`

- 📚 **Modular Architecture**
    - Follows clean layering: `controller`, `service`, `repository`, `entity`, `dto`, `mapper`

---

## 🧱 Tech Stack

| Layer        | Tech                     |
|--------------|--------------------------|
| Backend      | Java 21, Spring Boot 3.5 |
| ORM          | Spring Data JPA + Hibernate |
| Mapping      | MapStruct                |
| Validation   | Spring Boot Validation   |
| DB           | MySQL (HikariCP)         |
| Migration    | *Flyway* (to be added)   |
| Build Tool   | Maven                    |

---

## 🧪 API Endpoints

### 🧍 User
| Method | Path           | Description          |
|--------|----------------|----------------------|
| GET    | `/api/v1/user` | Basic User Check     |

### 💵 Budget
| Method | Path                    | Description         |
|--------|-------------------------|---------------------|
| POST   | `/api/v1/budgets`       | Create a budget     |
| PUT    | `/api/v1/budgets/{id}`  | Update a budget     |
| GET    | `/api/v1/budgets/{id}`  | Get budget by ID    |
| DELETE | `/api/v1/budgets/{id}`  | Delete a budget     |

### 💳 Transactions
| Method | Path                          | Description             |
|--------|-------------------------------|-------------------------|
| POST   | `/api/v1/transactions`        | Add new transaction     |
| PUT    | `/api/v1/transactions/{id}`   | Update transaction      |
| GET    | `/api/v1/transactions/{id}`   | Get transaction by ID   |
| GET    | `/api/v1/transactions/user/{id}` | List user transactions |
| DELETE | `/api/v1/transactions/{id}`   | Delete transaction      |
