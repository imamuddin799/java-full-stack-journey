# Blog Web Application
A lightweight Spring Boot MVC web application for publishing and commenting on blog posts. Uses **Thymeleaf**, **Spring Data JPA**, **MySQL**, **Bootstrap**, **jQuery**, and **CKEditor**.

## Overview
This project provides:
- User registration and session-based authentication.
- Create, edit, soft-delete blogs with rich text (CKEditor).
- Public commenting with AJAX posting and owner moderation.
- AJAX search across title, short description, and content.
- Client- and server-side validation; password hashing with BCrypt.

## Key Features
- **User accounts**: register, login, logout (session attributes `USER_ID`, `USER_NAME`).
- **Blog management**: add, edit, soft-delete, list (owner-only edit/delete).
- **Rich content**: CKEditor for blog content.
- **Comments**: AJAX-based add/list/delete (owner moderation).
- **Search**: Debounced AJAX search endpoint.
- **Validation**: Title uniqueness check via AJAX; Jakarta Bean Validation server-side.
- **Pagination**: For user-specific lists (blogs, comments).

## Technology Stack
- **Backend:** Spring Boot 3 (Spring MVC), Spring Data JPA  
- **View:** Thymeleaf  
- **Database:** MySQL  
- **Build:** Maven  
- **Security:** Spring Security Crypto (BCrypt) for password hashing  
- **Frontend:** Bootstrap 5, jQuery, CKEditor 5  
- **Validation:** Jakarta Bean Validation  
- **Utilities:** Lombok (optional), DevTools (optional)

## Architecture (High Level)
MVC layers:
- **Controller**: handles HTTP requests, returns Thymeleaf views or JSON for AJAX.
- **Service**: business logic, validation, ownership checks.
- **Repository**: Spring Data JPA for DB access.
- **Database**: MySQL tables `users`, `blogs`, `comments`.

## Project Structure
```text
.
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── in
│   │   │       └── ansari
│   │   │               ├── BlogAppApplication.java
│   │   │               ├── ServletInitializer.java
│   │   │               ├── config
│   │   │               │   └── WebConfig.java
│   │   │               ├── controller
│   │   │               │   ├── AuthController.java
│   │   │               │   ├── BlogController.java
│   │   │               │   ├── CommentController.java
│   │   │               │   ├── CommentRestController.java
│   │   │               │   └── SearchController.java
│   │   │               ├── dto
│   │   │               │   ├── BlogRequest.java
│   │   │               │   ├── BlogResponse.java
│   │   │               │   ├── CommentRequest.java
│   │   │               │   ├── CommentResponse.java
│   │   │               │   ├── LoginRequest.java
│   │   │               │   └── RegisterRequest.java
│   │   │               ├── exception
│   │   │               │   ├── ResourceNotFoundException.java
│   │   │               │   └── UnauthorizedException.java
│   │   │               ├── entity
│   │   │               │   ├── User.java
│   │   │               │   ├── Blog.java
│   │   │               │   └── Comment.java
│   │   │               ├── repository
│   │   │               │   ├── UserRepository.java
│   │   │               │   ├── BlogRepository.java
│   │   │               │   └── CommentRepository.java
│   │   │               ├── service
│   │   │               │   ├── UserService.java
│   │   │               │   ├── BlogService.java
│   │   │               │   └── CommentService.java
│   │   │               └── service
│   │   │                   └── impl
│   │   │                       ├── UserServiceImpl.java
│   │   │                       ├── BlogServiceImpl.java
│   │   │                       └── CommentServiceImpl.java
│   │   └── resources
│   │       ├── application.properties
│   │       ├── schema.sql
│   │       ├── static
│   │       │   ├── css
│   │       │   │   └── styles.css
│   │       │   └── js
│   │       │       ├── ajax-search.js
│   │       │       └── ajax-validation.js
│   │       └── templates
│   │           ├── fragments
│   │           │   ├── header.html
│   │           │   └── footer.html
│   │           ├── add-blog.html
│   │           ├── edit-blog.html
│   │           ├── index.html
│   │           ├── login.html
│   │           ├── register.html
│   │           ├── my-blogs.html
│   │           ├── my-comments.html
│   │           └── view-blog.html
└── README.md

```
## Prerequisites
- Java 21 or later  
- Maven 3.6+  
- MySQL 8+ (recommended)  
- Optional: IDE (IntelliJ, Eclipse), Postman for API testing

## Configuration (application.properties)
Update `src/main/resources/application.properties` with DB credentials:

```properties
spring.application.name=blog-app

# Datasource
spring.datasource.url=jdbc:mysql://localhost:<mysql-port>/blog_app?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&useUnicode=true&characterEncoding=utf8
spring.datasource.username=<your-mysql-userrname>
spring.datasource.password=<your-mysql-password>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# Thymeleaf
spring.thymeleaf.cache=false

# Initialize schema (optional)
spring.sql.init.mode=never
```

## Database Schema Summary (from schema.sql)
- **users**: `id`, `name`, `email` (unique), `password_hash`, `created_at`  
- **blogs**: `id`, `user_id` (FK), `title` (unique), `short_description` (unique), `content`, `is_deleted`, `created_at`, `updated_at`; fulltext index on `content`  
- **comments**: `id`, `blog_id` (FK), `name`, `email`, `comment_text`, `created_at`

## Build & Run
1. Clone repository:

```bash
git clone <your-repo-url>
cd blog-app
```
2. Configure DB in `application.properties`.

3. (Optional) Initialize schema:

```bash
mysql -u root -p < src/main/resources/schema.sql
```
4. Build:

```bash
mvn clean package
```
5. Run

```bash
mvn spring-boot:run
# or
java -jar target/blog-app-0.0.1-SNAPSHOT.war
```
6. Open: `http://localhost:8080`

## Endpoints
- GET     /                       -> Home page (list blogs)
- GET     /search?q=...           -> AJAX search (JSON)
- GET     /blogs/add              -> Add blog form
- POST    /blogs/add              -> Create blog
- GET     /blogs/{id}             -> View blog
- GET     /blogs/{id}/edit        -> Edit blog form
- POST    /blogs/{id}/edit        -> Update blog
- POST    /blogs/{id}/delete      -> Soft-delete blog
- GET     /blogs/validate/title   -> Title uniqueness check (returns boolean)
- GET     /blogs/my-blogs         -> User's blogs (paginated)
- GET     /comments/{blogId}      -> Get comments for blog (JSON)
- POST    /comments/{blogId}      -> Add comment (JSON body: { name, email, commentText })
- DELETE  /comments/{blogId}/{commentId} -> Delete comment (owner)
- DELETE  /comments/owner/{commentId}    -> Delete comment (owner modal)
- GET     /comments/my-comments   -> Comments on user's blogs (paginated)
- GET     /login                  -> Login page
- POST    /login                  -> Login submit
- GET     /register               -> Register page
- POST    /register               -> Register submit
- GET     /logout                 -> Logout action

## Controllers / Services / Repositories
- **Controllers**: SearchController, BlogController, CommentController, CommentRestController, AuthController  
- **Services**: UserService, BlogService, CommentService  
- **Repositories**: UserRepository, BlogRepository, CommentRepository (extend `JpaRepository`)  
- **Entities**: User, Blog, Comment

## Frontend Notes
- Templates use Thymeleaf fragments for header/footer.  
- `static/js/ajax-search.js` implements debounced search and renders `#blogList`.  
- `static/js/ajax-validation.js` checks `/blogs/validate/title` for duplicates.  
- CKEditor used in add/edit pages.  
- Session attributes `session.USER_ID` and `session.USER_NAME` control UI visibility.

## Future Improvements
- Integrate Spring Security for robust auth and roles.  
- Add image/file uploads for posts.  
- Improve search with Elasticsearch or advanced fulltext ranking.  
- Add unit/integration tests and CI pipeline.  
- Provide Dockerfile and docker-compose for local development.

## Contributing
1. Fork the repository.  
2. Create a branch: `git checkout -b feature/your-feature`.  
3. Commit changes with clear messages.  
4. Open a pull request with description and rationale.  
5. Ensure build passes and basic manual tests succeed.

### 🧑‍💻 Author
Imamuddin Ansari
📍 Java Developer | Spring Boot | JSP | MySQL

### ⭐ Support
If you find this project helpful:
- 🌟 Star this repository on GitHub
- 🐛 Open issues or pull requests to contribute
- 💬 Share feedback or suggest improvements
