CREATE DATABASE teacherLogin;

USE teacherLogin;

CREATE TABLE student
(
	studentID INT NOT NULL auto_increment,
    fName VARCHAR(40) NOT NULL,
    sName VARCHAR(40) NOT NULL,
    age INT,
    PRIMARY KEY (studentID)
);

CREATE TABLE teacher
(
	teacherID INT NOT NULL auto_increment,
    fName VARCHAR(40) NOT NULL,
    sName VARCHAR(40) NOT NULL,
	username VARCHAR(40) NOT NULL,
    password VARCHAR(40) NOT NULL,
    PRIMARY KEY(teacherID)
);

CREATE TABLE teacherAllocation
(
	teacherID INT NOT NULL,
    studentID INT NOT NULL,
    PRIMARY KEY(teacherID, studentID),
    FOREIGN KEY(teacherID) REFERENCES Teacher(teacherID),
    FOREIGN KEY(studentID) REFERENCES Student(studentID)
);

INSERT INTO student(studentID, fName, sName, age) VALUES (null,"Louis", "F",18);
INSERT INTO student(studentID, fName, sName, age) VALUES (null,"Elliot", "C",18);
INSERT INTO student(studentID, fName, sName, age) VALUES (null,"John", "K",18);
INSERT INTO student(studentID, fName, sName, age) VALUES (null,"Emily", "T",18);
INSERT INTO student(studentID, fName, sName, age) VALUES (null,"Jeff", "F",18);

INSERT INTO teacher(teacherID, fName, sName, username, password) VALUES (null, "Bruce", "C", "BrucieMan101", "password");
INSERT INTO teacher(teacherID, fName, sName, username, password) VALUES (null, "John", "P", "JohnJohn", "greggsislife");

INSERT INTO teacherAllocation (teacherID, studentID) VALUES (1,1);
INSERT INTO teacherAllocation (teacherID, studentID) VALUES (1,2);
INSERT INTO teacherAllocation (teacherID, studentID) VALUES (2,3);
INSERT INTO teacherAllocation (teacherID, studentID) VALUES (1,4);
INSERT INTO teacherAllocation (teacherID, studentID) VALUES (2,5);

SELECT * FROM student;
SELECT * FROM teacher;
SELECT * FROM teacherAllocation;