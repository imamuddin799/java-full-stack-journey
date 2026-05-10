# ✨ 02_Mini_Project

*A small Spring Boot MVC application that manages user accounts and student enquiries. Features include user registration with email-based unlock, login, forgot-password flow, CRUD for student enquiries, and a simple dashboard.*

---

## 🚀 Overview

This project is a server-rendered **Spring Boot MVC web application** designed to manage:

- User registration, unlock and authentication flows
- Email-based temporary password distribution (SMTP)
- Enquiry creation, update, listing and in-memory filtering
- Dashboard metrics (total, enrolled, lost) per user
- Thymeleaf (or other template engine) view rendering

---

## 🧰 Requirements

- Java 11+ (or the JDK your environment uses)  
- Maven (or Gradle)  
- MySQL server  
- SMTP account (example: Gmail with app password)  
- Browser for UI

---

## ⚙️ Configuration

Create or update `src/main/resources/application.properties` with the following template and replace placeholders:

```properties
spring.application.name=02_Mini_Project
spring.datasource.username=<your-mysql-username>
spring.datasource.password=<your-mysql-password>
spring.datasource.url=jdbc:mysql://localhost:<port>/<your-database-name>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=<your-email-address>
spring.mail.password=<your-gmail-app-password>
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

> Important: Replace placeholders inside application.properties before running the app.

- Replace values like `<your-mysql-username>`, `<your-mysql-password>`, `<port>`, `<your-database-name>`, `<your-email-address>`, and `<your-gmail-app-password>` with your real values.
- For Gmail SMTP use an app password (not your regular Gmail password). See Google account security settings to create an app password.
- Never commit credentials or app passwords to version control. Use environment variables, a secrets manager, or an external config file excluded from the repository (for example, add `src/main/resources/application.properties` to `.gitignore` when it contains real credentials).


## 🗄️ Database Notes

With `spring.jpa.hibernate.ddl-auto=update` JPA will create/update schema automatically. Typical tables implied by the code:

- `user_details` — stores username, userEmail, userPhoneNumber, password, accountStatus, relationship to enquiries
- `student_enquiry` — stores enquiryId, studentName, studentPhoneNumber, classMode, courseName, enquiryStatus, many-to-one to user_details
- `course` — stores course entries used to populate course dropdown
- `enquiry_status` — stores allowed enquiry status values used for dropdowns

For production use, prefer explicit SQL migrations (Flyway or Liquibase) instead of relying on auto-ddl.

## ▶️ How to Run

1. Set values in `application.properties`.  
2. Ensure MySQL is running and the configured database exists.  
3. Build and run the application:
   - Using Maven:
     - `mvn clean package`
     - `java -jar target/<artifact>.jar`
   - Or run from your IDE as a Spring Boot application.  
4. Open a browser and visit:
   - `http://localhost:8080/`

## 🌐 Key Pages and Endpoints

- `GET /` -> index  
- `GET /signup` -> registration page  
- `POST /signup` -> create user and send unlock email  
- `GET /unlock?email=...` -> unlock form (prefilled)  
- `POST /unlock` -> verify temporary password and set new password  
- `GET /login` -> login page  
- `POST /login` -> authenticate and set session `userId`  
- `GET /forgot` -> forgot-password page  
- `POST /forgot` -> initiate forgot-password flow (emails stored password)  
- `GET /dashboard` -> dashboard metrics for logged-in user  
- `GET /enquiry` -> add-enquiry page  
- `POST /enquiry` -> create or update enquiry  
- `GET /update?enquiryId=...` -> edit enquiry page  
- `GET /enquiries` -> list enquiries for logged-in user  
- `GET /filtered-enquiries?course=...&status=...&mode=...` -> filtered results

Controllers return logical view names; configure a template engine (Thymeleaf) and place templates under `src/main/resources/templates`.

## 🔐 Current Behavior and Security Notes

- Passwords are generated, stored and compared in plain text across flows (signup, unlock, login, forgot-password). This is insecure for production.
- The forgot-password flow emails the stored password. Replace this with a secure reset-token workflow.
- Session stores the authenticated user's id under attribute `userId`. Consider stateless authentication (JWT) for APIs.
- Filtering and counts are performed in-memory from loaded entity collections; move to repository/database queries with pagination for large datasets.

## ✔ Immediate recommendations before public deployment:
- Hash passwords (BCrypt via Spring Security) and never store or email raw passwords.
- Implement time-limited reset tokens for password recovery and account unlock.
- Use Spring Security for authentication, authorization and session management.
- Validate all form inputs (Bean Validation) and sanitize outputs.
- Replace fragile string constants (status, classMode) with enums or central constants.

## 📈 Improvements and Next Steps

- Add Bean Validation annotations on binding classes (SignUpForm, LoginForm, UnlockForm, EnquiryForm) and validate inputs in controllers.
- Move email and password flows to secure token-based mechanisms (time-limited tokens for reset/unlock).
- Move filtering and aggregation into repository queries with pagination to handle large datasets.
- Integrate Spring Security for authentication, password encoding (BCrypt), and authorization.
- Add structured logging (SLF4J + Logback) and centralized exception handling (ControllerAdvice).
- Introduce integration and unit tests (MockMvc, Mockito, Testcontainers for DB).
- Use Flyway or Liquibase for schema migrations and seed data for courses and enquiry_status.

## 📚 Summary
This project teaches Spring MVC, JPA, email flows, session auth, CRUD operations, and dashboard analytics.

### 🧑‍💻 Author
Imamuddin Ansari
📍 Java Developer | Spring Boot | JSP | MySQL

### ⭐ Support
If you find this project helpful:
- 🌟 Star this repository on GitHub
- 🐛 Open issues or pull requests to contribute
- 💬 Share feedback or suggest improvements

