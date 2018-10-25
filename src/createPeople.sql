CREATE DATABASE people;

USE people;

CREATE TABLE user
(
	idNum int NOT NULL auto_increment,
    username char(20) NOT NULL UNIQUE,
    password char(20) NOT NULL,
    fName char(20),
    sName char(20),
    PRIMARY KEY (idNum)
);

SELECT * FROM user;

INSERT INTO user VALUES (null, "louis1407","password","louis","F");
INSERT INTO user VALUES (null, "someGeezer", "12345", "fake", "man");

SELECT * FROM user;


