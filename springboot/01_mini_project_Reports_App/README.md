# 🧾 Citizen Plan Reports

## 📘 Overview

**Citizen Plan Reports** is a **Spring Boot web application** for generating reports of citizen plans in **Excel** and **PDF** formats.  
It provides a **search feature** to filter records by plan name, status, and gender, and also supports **sending reports via email** as attachments.

---

## ✨ Features

✅ Search citizen plans by:
- Plan Name  
- Plan Status  
- Gender  
- Start & End Dates  

✅ Export data as:
- 📊 **Excel Reports** (using Apache POI)  
- 📄 **PDF Reports** (using OpenPDF)

✅ Send reports directly to email 📧  
✅ JSP + Spring MVC based frontend  
✅ Data persistence using Spring Data JPA & MySQL  
✅ Configurable SMTP settings for email delivery

---

## 🧠 Tech Stack
| Layer | Technology |
|:--|:--

| **Frontend** | JSP, JSTL, HTML, CSS |

| **Backend** | Spring Boot, Spring MVC, Spring Data JPA |

| **Database** | MySQL |

| **Libraries** | Apache POI (Excel), OpenPDF (PDF), JavaMailSender (Email) |

| **Server** | Tomcat 9 |

| **Language** | Java 21 |

---

## ⚙️ Setup & Installation

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/imamuddin799/01_mini_project_Reports_App.git
cd 01_mini_project_Reports_App
```
### 2️⃣ Configure Database
- Create a MySQL database named jrtp
- Update credentials in application.properties:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jrtp
spring.datasource.username=root
spring.datasource.password=root
```
### 3️⃣ Configure Email
Use your Gmail and app-specific password:

```properties
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password
```

### 4️⃣ Run the App
Use your IDE (STS/IntelliJ) or command line:

```bash
mvn spring-boot:run
```

### 5️⃣ Access the App
Open in your browser:

```arduino
http://localhost:8080/
```

### 📦 Folder Structure

```bash
01_mini_project_Reports_App/
│
├── src/main/java/com/ansari/
│   ├── controller/      # Handles web requests
│   ├── entity/          # JPA entities
│   ├── repo/            # Repository interfaces
│   ├── request/         # Request model classes
│   ├── service/         # Service layer interfaces & implementations
│   └── utils/           # Utility classes (Email, Excel, PDF)
│
├── src/main/resources/
│   ├── application.properties
│
├── src/main/webapp/pages
│   ├── index.jsp 	#jsp
│
├── pom.xml
└── README.md
```
### 📧 Email Example
When you click "Send Excel to Email" or "Send PDF to Email",
the app will automatically attach the generated file and send it to your configured Gmail.

### 🧑‍💻 Author
Imamuddin Ansari
📍 Java Developer | Spring Boot | JSP | MySQL

### ⭐ Support
If you find this project helpful:
- 🌟 Star this repository on GitHub
- 🐛 Open issues or pull requests to contribute
- 💬 Share feedback or suggest improvements
