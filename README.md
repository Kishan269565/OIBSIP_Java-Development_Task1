# Railway Reservation System (Java + MySQL)

A simple **Java Swing** application for:
- **User Login**
- **Train Reservation**
- **Ticket Cancellation**
- **MySQL Database Integration**

---

## 📂 Project Structure
OIBSIP_Java Development_Task1/
**├── LoginForm.java**
├── ReservationForm.java
├── CancellationForm.java
└── lib/
└── mysql-connector-j-9.4.0.jar

---


## 🛠 Prerequisites

- **Java JDK** 11 or later  
- **MySQL Server** (local or cloud)  
- **MySQL Connector/J** (Already included in `lib/` folder)  
- MySQL Database with required tables

---

## 🗄 Database Setup

1. Create a MySQL database:
```sql
CREATE DATABASE railway;
USE railway;

Create users table:

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL
);


Create reservations table:

CREATE TABLE reservations (
    pnr INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    name VARCHAR(100) NOT NULL,
    train_no VARCHAR(20) NOT NULL,
    class_type VARCHAR(20) NOT NULL,
    date_of_journey DATE NOT NULL,
    source VARCHAR(50) NOT NULL,
    destination VARCHAR(50) NOT NULL
);

---
## ⚙ Configuration

Inside your Java files, update the DB connection string:

private static final String DB_URL = "jdbc:mysql://<HOST>:<PORT>/<DB_NAME>";
private static final String DB_USER = "<USERNAME>";
private static final String DB_PASSWORD = "<PASSWORD>";


Example (FreeSQLDatabase.com):

private static final String DB_URL = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12794970";
private static final String DB_USER = "sql12794970";
private static final String DB_PASSWORD = "yourpassword";

---
## 💻 Compilation & Running

Open terminal in the project folder:

1. Compile all Java files:
javac -cp ".;lib/mysql-connector-j-9.4.0.jar" LoginForm.java ReservationForm.java CancellationForm.java

2. Run the application (start with login):
java -cp ".;lib/mysql-connector-j-9.4.0.jar" LoginForm

---
## 🔑 Features
Login Form

Validates user credentials from the users table.
On success → Opens Reservation Form.

Reservation Form

Filds: Name, Train No, Class Type, Date of Journey, From, To.
Inserts reservation into reservations table.
Date format must be YYYY-MM-DD.
Cancellation Form
Accepts PNR number.
Deletes matching record from reservations table.
---
## Common Errors & Fixes

1. No suitable driver found
Ensure mysql-connector-j-9.4.0.jar is in lib/ and included in -cp.
2. Unknown column 'name'
Make sure your table column names match exactly with your Java INSERT query.
3. Date format error
MySQL accepts YYYY-MM-DD. Convert from DD/MM/YYYY in code before inserting.

---
## 📌 License


This project is free to use for educational purposes.
