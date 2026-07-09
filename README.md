# Registration App (Java MVC | Servlets | JDBC | JSP)

A user registration web application built using core Java EE technologies — Servlets, JSP, and JDBC — following the MVC (Model-View-Controller) design pattern. Built without any external frameworks to understand how request handling, session management, and data persistence work under the hood.

## Overview

A user fills out a registration form (name, email, password, city). The form submits to a Servlet controller, which passes the data to a Model class that persists it to a MySQL database using JDBC. The Servlet also creates a session to store the username, which is used to personalize the response. Based on whether the database insert succeeds, the user is redirected to a success or failure page.

## Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 21 |
| Web Layer | Jakarta Servlets, JSP |
| Persistence | JDBC (MySQL Connector/J) |
| Database | MySQL |
| Server | Apache Tomcat 10.1 |
| Session Management | `HttpSession` |

## Architecture (MVC)

```
Browser (index.html)
      │  POST /Register
      ▼
Registration.java  ──────────────►  Controller
      │  reads request params,
      │  creates session
      ▼
Model.java  ───────────────────────►  Model
      │  business logic + JDBC
      ▼
JdbcUtil.java  ─────────────────────►  DB access helper
      │
      ▼
MySQL Database (Registration.primary_info)

      │ success / failure
      ▼
success.jsp / failed.jsp  ─────────►  View
```

- **Controller** — `Registration.java` is a Servlet mapped to `/Register`. It reads form parameters (`uname`, `email`, `password`, `ucity`), delegates persistence to the Model, stores the username in the session, and redirects to `success.jsp` or `failed.jsp`.
- **Model** — `Model.java` is a POJO holding the user's data, with a `register()` method that inserts a new row into the database using a `PreparedStatement` (protects against SQL injection).
- **View** — `index.html` (registration form), `success.jsp` and `failed.jsp` (outcome pages that read the username from the session to personalize the greeting).
- **Data Access Helper** — `JdbcUtil.java` centralizes the JDBC connection setup and resource cleanup used by the Model.

## Project Structure

```
RegistrationAppMVC/
├── src/main/java/
│   ├── Registration.java      # Controller (Servlet)
│   ├── Model.java             # Model (business logic + persistence)
│   └── JdbcUtil.java          # DB connection utility
├── src/main/webapp/
│   ├── index.html             # Registration form (View)
│   ├── success.jsp            # Success page (View)
│   ├── failed.jsp             # Failure page (View)
│   └── WEB-INF/web.xml        # Deployment descriptor
└── README.md
```

## Getting Started

### Prerequisites

- JDK 21
- Apache Tomcat 10.1+
- MySQL 8+
- MySQL Connector/J (added to build path / `WEB-INF/lib`)
- Eclipse (or any IDE with Dynamic Web Project + Tomcat support)

### 1. Set up the database

```sql
CREATE DATABASE Registration;

USE Registration;

CREATE TABLE primary_info (
    id INT AUTO_INCREMENT PRIMARY KEY,
    uname VARCHAR(100),
    emailid VARCHAR(100),
    passwrod VARCHAR(100),
    city VARCHAR(100)
);
```

### 2. Configure the database connection

Update the connection details in `JdbcUtil.java` to match your local MySQL setup:

```java
String url = "jdbc:mysql://localhost:3306/Registration";
String user = "root";
String p_w = "your_password";
```

### 3. Run it

1. Import the project into Eclipse as a **Dynamic Web Project**.
2. Add the MySQL Connector/J JAR to the build path / `WEB-INF/lib`.
3. Deploy to Tomcat 10.1+ and start the server.
4. Visit `http://localhost:8080/RegistrationAppMVC/`.

## What This Project Demonstrates

- Implementing MVC manually with Servlets, without a framework like Spring
- Handling HTTP form submissions and reading request parameters
- Using `PreparedStatement` for safe SQL execution
- Managing user state across requests with `HttpSession`
- Structuring a Java web app into clear Controller / Model / View layers
