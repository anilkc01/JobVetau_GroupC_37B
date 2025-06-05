create database classwork;
use classwork;

CREATE TABLE students (
    student_id INT PRIMARY KEY,
    name VARCHAR(100)
);

INSERT INTO students (student_id, name) VALUES
(1, 'Alice Smith'),
(2, 'Bob Johnson'),
(3, 'Charlie Brown'),
(4, 'Diana Wilson'),
(5, 'Emma Davis'),
(6, 'Frank Miller'),
(7, 'Grace Lee'),
(8, 'Henry Clark'),
(9, 'Isabella Martinez'),
(10, 'James Taylor');


CREATE TABLE courses (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(100)
);

INSERT INTO courses (course_id, course_name) VALUES
(1, 'Mathematics'),
(2, 'Physics'),
(3, 'Chemistry'),
(4, 'Biology'),
(5, 'Computer Science'),
(6, 'History');


CREATE TABLE enrollments (
    enrollment_id INT PRIMARY KEY,
    student_id INT,
    course_id INT,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

INSERT INTO enrollments (enrollment_id, student_id, course_id) VALUES
(1, 1, 1), (2, 1, 2), (3, 1, 3), (4, 1, 4),
(5, 2, 2), (6, 2, 3), (7, 2, 4), (8, 2, 5),
(9, 3, 3), (10, 3, 4), (11, 3, 5), (12, 3, 6),
(13, 4, 1), (14, 4, 3), (15, 4, 5), (16, 4, 6),
(17, 5, 2), (18, 5, 4), (19, 5, 5), (20, 5, 6),
(21, 6, 1), (22, 6, 2), (23, 6, 3), (24, 6, 5),
(25, 7, 1), (26, 7, 4), (27, 7, 5), (28, 7, 6),
(29, 8, 2), (30, 8, 3), (31, 8, 4), (32, 8, 6),
(33, 9, 1), (34, 9, 2), (35, 9, 5), (36, 9, 6),
(37, 10, 1), (38, 10, 3), (39, 10, 4), (40, 10, 5);


CREATE TABLE grades (
    grade_id INT PRIMARY KEY,
    enrollment_id INT,
    grade CHAR(2), -- e.g., 'A', 'B', etc.
    FOREIGN KEY (enrollment_id) REFERENCES enrollments(enrollment_id)
);

INSERT INTO grades (grade_id, enrollment_id, grade) VALUES
(1, 1, 'A'), (2, 2, 'B'), (3, 3, 'C'), (4, 4, 'A'),
(5, 5, 'B'), (6, 6, 'A'), (7, 7, 'C'), (8, 8, 'D'),
(9, 9, 'A'), (10, 10, 'B'), (11, 11, 'C'), (12, 12, 'F'),
(13, 13, 'A'), (14, 14, 'B'), (15, 15, 'A'), (16, 16, 'C'),
(17, 17, 'D'), (18, 18, 'B'), (19, 19, 'A'), (20, 20, 'C'),
(21, 21, 'B'), (22, 22, 'A'), (23, 23, 'C'), (24, 24, 'D'),
(25, 25, 'A'), (26, 26, 'F'), (27, 27, 'B'), (28, 28, 'A'),
(29, 29, 'C'), (30, 30, 'B'), (31, 31, 'A'), (32, 32, 'D'),
(33, 33, 'A'), (34, 34, 'C'), (35, 35, 'B'), (36, 36, 'A'),
(37, 37, 'B'), (38, 38, 'C'), (39, 39, 'A'), (40, 40, 'D');

SELECT * FROM grades;



DELIMITER //

CREATE PROCEDURE student_report(IN student_id INT)
BEGIN
    SELECT 
        c.course_name,
        g.grade
    FROM students s
    INNER JOIN enrollments e ON s.student_id = e.student_id
    INNER JOIN courses c ON e.course_id = c.course_id
    INNER JOIN grades g ON e.enrollment_id = g.enrollment_id
    WHERE s.student_id = student_id;
    
    SELECT getGPA(student_id) ;
END //

DELIMITER ;

DROP PROCEDURE student_report;
CALL student_report(4);


DELIMITER //
CREATE FUNCTION getGPA(s_id INT)
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE gpa FLOAT;
     
    SELECT 
        AVG(CASE 
            WHEN g.grade = 'A' THEN 4.0
            WHEN g.grade = 'B' THEN 3.6
            WHEN g.grade = 'C' THEN 3.0
            WHEN g.grade = 'D' THEN 2.0
            ELSE 0.0
        END) INTO gpa
    FROM students s
    INNER JOIN enrollments e ON s.student_id = e.student_id
    INNER JOIN grades g ON e.enrollment_id = g.enrollment_id
    WHERE s.student_id = s_id;
    
    RETURN IFNULL(gpa,0);
END //
DELIMITER ;

