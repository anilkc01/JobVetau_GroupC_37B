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
SELECT * FROM users;
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
CREATE TABLE applications (
    id INT PRIMARY KEY AUTO_INCREMENT,
    seeker_id INT NOT NULL,
    job_id INT NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'Pending',
    FOREIGN KEY (seeker_id) REFERENCES seekers(id) ON DELETE CASCADE,
    FOREIGN KEY (job_id) REFERENCES jobs(id) ON DELETE CASCADE
);
SELECT * FROM applications;
UPDATE  applications SET status = "Rejected" WHERE id = 2;
DELIMITER //

CREATE PROCEDURE getJobs(IN seekerId INT)
BEGIN
    SELECT j.id, j.title, j.description, j.location, j.salary, j.mode, 
           j.posted_date, j.company_id, u.name AS company_name
    FROM jobs j
    JOIN companies c ON j.company_id = c.id
    JOIN users u ON c.id = u.id
    WHERE j.id NOT IN (
        SELECT job_id 
        FROM applications 
        WHERE seeker_id = seekerId
    );
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE getAppliedJobs(IN seekerId INT)
BEGIN
    SELECT j.id, j.title, j.description, j.location, j.salary, j.mode, 
           j.posted_date, j.company_id, u.name AS company_name, a.status
    FROM jobs j
    JOIN companies c ON j.company_id = c.id
    JOIN users u ON c.id = u.id
    JOIN applications a ON j.id = a.job_id
    WHERE a.seeker_id = seekerId;
END //

DELIMITER ;

