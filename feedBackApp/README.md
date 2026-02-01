# Feedback Application

A Java EE web application for managing user feedback. Users can submit, view, edit, and delete feedback through a web interface.

## Features
- Submit new feedback with type, description, name, and email
- View all submitted feedbacks
- Edit existing feedback
- Delete feedback with confirmation
- MySQL database integration

## Prerequisites

Before running this application, ensure you have the following installed:

1. **Java Development Kit (JDK) 8 or higher**
   - Download from: https://www.oracle.com/java/technologies/downloads/
   - Verify installation: `java -version`

2. **Apache NetBeans IDE** (recommended) or any Java EE compatible IDE
   - Download from: https://netbeans.apache.org/download/
   - Version 8.2 or higher recommended

3. **GlassFish Server** (Java EE application server)
   - Usually bundled with NetBeans
   - Or download separately from: https://javaee.github.io/glassfish/download
   - Version 4.x or 5.x recommended

4. **MySQL Database Server**
   - Download from: https://dev.mysql.com/downloads/mysql/
   - Version 5.7 or higher recommended
   - MySQL Workbench (optional, for easier database management)

5. **MySQL JDBC Driver**
   - Download from: https://dev.mysql.com/downloads/connector/j/
   - Or the library should be available in NetBeans (libs.MySQLDriver.classpath)

## Database Setup

### Step 1: Install and Start MySQL

1. Install MySQL Server if not already installed
2. Start MySQL service:
   - **Windows**: Open Services and start MySQL service
   - **Linux/Mac**: `sudo service mysql start` or `sudo systemctl start mysql`

### Step 2: Create Database and Table

1. Open MySQL Workbench or command line client
2. Login to MySQL:
   ```bash
   mysql -u root -p
   ```
3. Run the SQL script provided in the project:
   ```bash
   source database_setup.sql
   ```
   
   Or manually execute the SQL commands:
   ```sql
   CREATE DATABASE IF NOT EXISTS web_db;
   USE web_db;
   
   CREATE TABLE IF NOT EXISTS feedback (
       id INT AUTO_INCREMENT PRIMARY KEY,
       type VARCHAR(100) NOT NULL,
       feedback TEXT NOT NULL,
       name VARCHAR(100) NOT NULL,
       email VARCHAR(100) NOT NULL,
       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
   );
   ```

### Step 3: Configure Database Credentials

Update the database credentials in `src/java/DatabaseConnection.java` if your MySQL setup is different:

```java
String dbUsername = "root";           // Change to your MySQL username
String dbPassword = "Your_Password";  // Change to your MySQL password
```

**Current default password in code: `It20244866@`** - Make sure to update this to match your MySQL root password!

## Project Setup in NetBeans

### Step 1: Open Project in NetBeans

1. Launch NetBeans IDE
2. Go to **File > Open Project**
3. Navigate to the project folder: `d:\SLIIIT\SLIIT SEM 3\FeedBack App\feedBackApp`
4. Select the project and click **Open Project**

### Step 2: Configure GlassFish Server

1. In NetBeans, go to **Tools > Servers**
2. If GlassFish is not listed:
   - Click **Add Server**
   - Select **GlassFish Server**
   - Browse to GlassFish installation directory
   - Complete the setup wizard
3. Ensure the server is running (right-click on server in Services tab > Start)

### Step 3: Add MySQL JDBC Driver to Libraries

1. Right-click on the project in Projects panel
2. Select **Properties**
3. Go to **Libraries** category
4. Click **Add JAR/Folder**
5. Navigate to MySQL Connector JAR file location (usually in NetBeans libs folder or downloaded separately)
6. Select `mysql-connector-java-x.x.x.jar` and click **Open**
7. Click **OK** to save

Alternatively, if using NetBeans library:
1. In Libraries section, click **Add Library**
2. Select **MySQL JDBC Driver** if available
3. Click **Add Library**

### Step 4: Verify Project Properties

1. Right-click project > **Properties**
2. Verify these settings:
   - **Sources**: Source/Binary Format should be JDK 8 or higher
   - **Build > Compile**: Ensure compiler is configured properly
   - **Run**: Server should be set to GlassFish Server

## Running the Application

### Method 1: Run from NetBeans (Recommended)

1. Right-click on the project in the Projects panel
2. Select **Clean and Build** (this compiles the project)
3. Wait for build to complete successfully
4. Right-click on the project again
5. Select **Run**
6. NetBeans will:
   - Deploy the application to GlassFish
   - Start the server if not running
   - Open the application in your default web browser

### Method 2: Deploy Manually to GlassFish

1. Build the project: Right-click project > **Clean and Build**
2. Locate the WAR file in: `dist/feedBackApp.war`
3. Open GlassFish Admin Console:
   - URL: http://localhost:4848
   - Default username: admin
   - Default password: (usually blank or 'admin')
4. Go to **Applications** in left menu
5. Click **Deploy**
6. Browse to the WAR file and upload
7. Click **OK** to deploy
8. Access application at: http://localhost:8080/feedBackApp/

### Method 3: Using Ant Build

1. Open terminal/command prompt
2. Navigate to project directory:
   ```bash
   cd "d:\SLIIIT\SLIIT SEM 3\FeedBack App\feedBackApp"
   ```
3. Build the project:
   ```bash
   ant clean
   ant compile
   ant dist
   ```
4. Deploy the generated WAR file manually to GlassFish

## Application URLs

Once the application is running:

- **Home Page (Submit Feedback)**: http://localhost:8080/feedBackApp/
- **View All Feedbacks**: http://localhost:8080/feedBackApp/seeFeedback
- **Edit Feedback**: Click "Edit" button on feedback list
- **Delete Feedback**: Click "Delete" button in edit page

## Project Structure

```
feedBackApp/
├── src/
│   ├── java/
│   │   ├── DatabaseConnection.java    # Database connection utility
│   │   ├── submitFeedback.java        # Servlet to handle feedback submission
│   │   ├── seeFeedback.java           # Servlet to display all feedbacks
│   │   ├── editFeedback.java          # Servlet to show edit form
│   │   ├── updateFeedBack.java        # Servlet to process feedback updates
│   │   └── deleteFeedback.java        # Servlet to handle feedback deletion
│   └── conf/
│       └── MANIFEST.MF
├── web/
│   ├── index.jsp                       # Home page with feedback form
│   ├── index.html
│   └── WEB-INF/
│       ├── web.xml                     # Web application configuration
│       └── glassfish-web.xml
├── build.xml                           # Ant build configuration
├── database_setup.sql                  # Database initialization script
└── README.md                           # This file
```

## Troubleshooting

### Issue 1: Database Connection Failed
**Error**: "Error 1: Communications link failure"

**Solution**:
- Ensure MySQL service is running
- Verify database credentials in `DatabaseConnection.java`
- Check if database `web_db` exists
- Verify port 3306 is open and MySQL is listening

### Issue 2: ClassNotFoundException - MySQL Driver
**Error**: "com.mysql.jdbc.Driver not found"

**Solution**:
- Add MySQL JDBC driver JAR to project libraries
- In NetBeans: Project Properties > Libraries > Add JAR/Folder
- Select mysql-connector-java-x.x.x.jar

### Issue 3: Server Start Failed
**Error**: "GlassFish Server cannot start"

**Solution**:
- Check if port 8080 is already in use
- Ensure GlassFish is properly installed
- Try starting server manually from Services tab
- Check GlassFish logs in server's log directory

### Issue 4: 404 Not Found
**Error**: "HTTP 404 - Not Found"

**Solution**:
- Verify application is deployed successfully
- Check deployment name in GlassFish admin console
- Ensure context path is correct
- Try accessing: http://localhost:8080/feedBackApp/index.jsp

### Issue 5: Build Failed
**Error**: "BUILD FAILED" in NetBeans

**Solution**:
- Clean the project: Right-click > Clean
- Check all dependencies are resolved
- Verify JDK is properly configured
- Check nbproject/project.properties for correct paths

## Default Credentials

- **MySQL Database**: `web_db`
- **MySQL Username**: `root`
- **MySQL Password**: `It20244866@` (Update this in DatabaseConnection.java!)

## Testing the Application

1. **Submit Feedback**:
   - Open home page
   - Fill in all fields (Type, Feedback, Name, Email)
   - Click SUBMIT
   - You should see "Feedback insert successfully!" message

2. **View Feedbacks**:
   - Click "See all feedbacks" link
   - All submitted feedbacks should be displayed
   - Each feedback shows name, type, and description

3. **Edit Feedback**:
   - Click "Edit" on any feedback
   - Modify the fields
   - Click UPDATE
   - Verify changes are saved

4. **Delete Feedback**:
   - Click "Edit" on feedback
   - Click "Delete" button
   - Confirm deletion
   - Verify feedback is removed from list

## Technologies Used

- **Backend**: Java Servlets (Java EE)
- **Database**: MySQL 5.7+
- **Server**: GlassFish 4.x/5.x
- **Build Tool**: Apache Ant
- **IDE**: Apache NetBeans
- **JDBC**: MySQL Connector/J

## Notes

- This is a college project for SLIIT Semester 3
- The application uses basic servlet technology without frameworks
- SQL injection protection should be improved for production use (use PreparedStatements consistently)
- Consider adding input validation and error handling for production
- Password should not be hardcoded in production applications

## Support

If you encounter any issues:
1. Check the troubleshooting section above
2. Verify all prerequisites are installed
3. Check GlassFish server logs for detailed error messages
4. Ensure database is running and accessible

## License

This is an educational project for SLIIT. Free to use for learning purposes.
