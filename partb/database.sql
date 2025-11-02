CREATE DATABASE company;
USE company;

CREATE TABLE employee (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    designation VARCHAR(50),
    salary DOUBLE
);

INSERT INTO employee VALUES (1, 'John', 'Manager', 50000);
INSERT INTO employee VALUES (2, 'Riya', 'Developer', 40000);
