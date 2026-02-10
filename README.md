# Feedback App — OOP

A Java EE web application for managing user feedback, built with Servlets, JSP, and MySQL. Users can submit, view, edit, and delete feedback through a simple web interface.

## Features

- Submit new feedback with type, description, name, and email
- View all submitted feedbacks
- Edit existing feedback
- Delete feedback with confirmation
- MySQL database integration

## Technologies Used

- **Backend**: Java Servlets (Java EE)
- **Frontend**: JSP (Java Server Pages)
- **Database**: MySQL 5.7+
- **Server**: GlassFish 4.x/5.x
- **Build Tool**: Apache Ant
- **IDE**: Apache NetBeans (recommended)
- **JDBC**: MySQL Connector/J

## Prerequisites

1. **JDK 8 or higher** — [Download](https://www.oracle.com/java/technologies/downloads/)
2. **Apache NetBeans IDE** (recommended) — [Download](https://netbeans.apache.org/download/)
3. **GlassFish Server** — Usually bundled with NetBeans, or [download separately](https://javaee.github.io/glassfish/download)
4. **MySQL Server 5.7+** — [Download](https://dev.mysql.com/downloads/mysql/)
5. **MySQL JDBC Driver** — [Download](https://dev.mysql.com/downloads/connector/j/)

## Quick Start

### 1. Set Up the Database

```bash
mysql -u root -p
```

```sql
source feedBackApp/database_setup.sql
```

This creates the `web_db` database and the `feedback` table with sample data.

### 2. Configure Database Credentials

Edit `feedBackApp/src/java/DatabaseConnection.java` and update the credentials to match your MySQL setup:

```java
String dbUsername = "root";            // Your MySQL username
String dbPassword = "your_password";  // Your MySQL password
```

### 3. Build and Run

**Using NetBeans (recommended):**

1. Open the `feedBackApp` project in NetBeans (**File > Open Project**)
2. Right-click the project → **Clean and Build**
3. Right-click the project → **Run**

**Using Ant from the command line:**

```bash
cd feedBackApp
ant clean
ant compile
ant dist
```

Then deploy the generated `dist/feedBackApp.war` to GlassFish.

### 4. Access the Application

| Page | URL |
|------|-----|
| Home / Submit Feedback | http://localhost:8080/feedBackApp/ |
| View All Feedbacks | http://localhost:8080/feedBackApp/seeFeedback |

## Project Structure

```
feedBackApp/
├── src/java/
│   ├── DatabaseConnection.java    # Database connection utility
│   ├── submitFeedback.java        # Handles feedback submission
│   ├── seeFeedback.java           # Displays all feedbacks
│   ├── editFeedback.java          # Shows edit form for a feedback
│   ├── updateFeedBack.java        # Processes feedback updates
│   └── deleteFeedback.java        # Handles feedback deletion
├── web/
│   ├── index.jsp                  # Home page with feedback form
│   └── WEB-INF/
│       ├── web.xml                # Web application configuration
│       └── glassfish-web.xml
├── build.xml                      # Ant build configuration
├── database_setup.sql             # Database initialization script
└── README.md
```

## Troubleshooting

| Problem | Solution |
|---------|----------|
| Database connection failed | Ensure MySQL is running, credentials are correct, and `web_db` exists |
| `ClassNotFoundException` for MySQL driver | Add `mysql-connector-java-x.x.x.jar` to project libraries |
| GlassFish won't start | Check if port 8080 is already in use |
| HTTP 404 | Verify the app is deployed and try http://localhost:8080/feedBackApp/index.jsp |
| Build failed | Clean the project, check dependencies, and verify JDK configuration |

## License

This is an educational project for SLIIT Semester 3. Free to use for learning purposes.
