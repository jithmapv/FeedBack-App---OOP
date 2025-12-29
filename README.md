# 📋 Feedback App – Java Servlet Web Application

A Java Servlet–based web application that implements full **CRUD (Create, Read, Update, Delete)** functionality for managing user feedback.  
This project uses **JSP/Servlets + JDBC**, is built with **Apache Ant**, and can be developed using **Microsoft Visual Studio** as the IDE.

---

## 📌 Features

- Submit new feedback
- View all feedback entries
- Edit existing feedback
- Update feedback records
- Delete feedback records
- Database-backed persistence using JDBC

---

## 🧱 Technology Stack

- **Language:** Java  
- **Web:** Java Servlets, JSP  
- **Database:** JDBC (MySQL or compatible RDBMS)  
- **Build Tool:** Apache Ant  
- **IDE:** Microsoft Visual Studio (folder-based project)  
- **Server:** Apache Tomcat / GlassFish  

---

FeedBack App/
├── db.txt                      # DB notes / credentials reference
├── feedback_app_jservlet.mp4   # Demo video
└── feedBackApp/
    ├── build.xml               # Ant build configuration
    ├── src/
    │   └── java/
    │       ├── DatabaseConnection.java
    │       ├── submitFeedback.java
    │       ├── seeFeedback.java
    │       ├── editFeedback.java
    │       ├── updateFeedBack.java
    │       └── deleteFeedback.java
    ├── web/                    # JSP / HTML resources
    ├── nbproject/              # NetBeans metadata (optional / can ignore)
    └── build/                  # Generated build output

---

## ⚙️ Component Overview

### `DatabaseConnection.java`
- Handles JDBC database connection setup
- Centralized connection logic used by all servlets

### `submitFeedback.java`
- Accepts feedback form submissions
- Inserts new feedback records into the database

### `seeFeedback.java`
- Retrieves and displays all feedback entries

### `editFeedback.java`
- Loads feedback data for editing based on ID

### `updateFeedBack.java`
- Updates existing feedback records in the database

### `deleteFeedback.java`
- Deletes feedback records using feedback ID

---

## 🗄️ Database Configuration

Required configuration:
- JDBC URL
- Database name
- Username
- Password

The `db.txt` file contains reference information for database setup.

---

## ▶️ Running the Project Using Microsoft Visual Studio

### ✅ Prerequisites

- Java JDK 8 or higher  
- Apache Ant  
- Apache Tomcat or GlassFish  
- MySQL (or compatible database)  
- Microsoft Visual Studio  

---

### 🧑‍💻 Step 1: Open Project

1. Open **Microsoft Visual Studio**
2. Click **File → Open → Folder**
3. Select the `feedBackApp` directory
4. Visual Studio will open the project as a folder workspace

> This is **not a Visual Studio solution** — VS is used as a code editor and terminal.

---

### 🔧 Step 2: Verify Java & Ant

In the Visual Studio terminal, verify:

```bash
java -version
ant -version

