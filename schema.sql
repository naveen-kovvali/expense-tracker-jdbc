CREATE DATABASE expenses;

USE expenses;

CREATE TABLE expensestable (
    id INT PRIMARY KEY AUTO_INCREMENT,
    amount DOUBLE,
    category VARCHAR(50),
    date DATE,
    description VARCHAR(100)
);