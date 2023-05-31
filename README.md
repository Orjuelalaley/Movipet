# Movipet

Movipet is a Java FX desktop application developed in IntelliJ IDEA. It allows users to register in a MySQL database and then log in to request services for their pets.

## Prerequisites

- Java Development Kit (JDK) 11 or higher
- MySQL Server
- IntelliJ IDEA

## Environment Setup

1. Clone or download the Movipet repository.
2. Open IntelliJ IDEA and select "Open" from the main menu.
3. Navigate to the project directory and select the root folder.
4. Wait for IntelliJ IDEA to configure the project.

## Database Setup

1. Start the MySQL server.
2. Create a database named "movipet".
3. Run the provided SQL script in the "database.sql" file to create the necessary tables in the database.

## Database Connection Configuration

1. Open the "src/main/resources/application.properties" file.
2. Modify the `db.url`, `db.username`, and `db.password` properties with your MySQL server connection information.

## Running the Application

1. In IntelliJ IDEA, open the "src/main/java/com/movipet/Main.java" file.
2. Right-click inside the class and select "Run Main.main()".
3. The application will run, and the login screen will be displayed.

## Features

- User Registration: Users can register by providing their name, email address, and password.
- Login: Users can log in using their email address and password.
- Service Request: Once logged in, users can request services for their pets, such as walks, day care, and overnight care.
- Service Management: Users can view a list of the services they have requested and cancel them if needed.
- Logout: Users can log out at any time.


## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
Recuerda que puedes personalizar el README.md según tus necesidades y preferencias.
