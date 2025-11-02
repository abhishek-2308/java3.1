CREATE DATABASE college;
USE college;

CREATE TABLE attendance (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(50),
    roll_no VARCHAR(20),
    status VARCHAR(10)
);
