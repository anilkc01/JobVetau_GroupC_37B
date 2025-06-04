CREATE DATABASE jobVetau;
USE jobVetau;
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT, 
    name VARCHAR(100),
    uname VARCHAR(50) UNIQUE,
    email VARCHAR(100) UNIQUE,
    number VARCHAR(15),
    address TEXT,
    role VARCHAR(10),
    password VARCHAR(255)
);
CREATE TABLE companies (
    id INT PRIMARY KEY,
    photo VARCHAR(255),
    regNo VARCHAR(20),
    sector VARCHAR(50),
    employees INT,
    ceo VARCHAR(100),
    website VARCHAR(100),
    service TEXT,
    FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE
);


CREATE TABLE seekers (
    id INT PRIMARY KEY, 
    photo VARCHAR(255),
    idNo VARCHAR(50),
    DOB DATE,
    experience TEXT,
    specialization VARCHAR(100),
    protfolio VARCHAR(255),
    FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE jobs (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    description TEXT NOT NULL, 
    location VARCHAR(100) NOT NULL,
    salary VARCHAR(50), 
    mode VARCHAR(10),
    posted_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    company_id INT NOT NULL,
    FOREIGN KEY (company_id) REFERENCES companies(id) ON DELETE CASCADE
);


