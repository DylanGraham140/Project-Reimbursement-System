CREATE TABLE MANAGERS
(
MANAGERS_ID int PRIMARY KEY AUTO_INCREMENT, 
MANAGERS_NAME varchar(200) UNIQUE NOT NULL,
BUDGET INT NOT NULL,
PIN INT NOT NULL
);

INSERT INTO basketballdb.MANAGERS VALS

CREATE TABLE EMPLOYEES
(
EMPLOYEES_ID INT PRIMARY KEY AUTO_INCREMENT,
EMPLOYEES_NAME varchar(200) UNIQUE NOT NULL,
PIN INT NOT NULL,
MANAGERS_ID INT NOT NULL,
CONSTRAINT FK_ACCOUNT 
FOREIGN KEY EMPLOYEES(MANAGERS_ID) 
REFERENCES MANAGERS(MANAGERS_ID)
);

CREATE TABLE REIMBURSEMENT 
(
REIMBURSEMENT_ID INT PRIMARY KEY AUTO_INCREMENT,
TITLE varchar(1000) NOT NULL,
COST INT NOT NULL,
REASON varchar(20000) NOT NULL,
EMPLOYEES_ID INT NOT NULL,
FOREIGN KEY REIMBURSEMENT(EMPLOYEES_ID) 
REFERENCES EMPLOYEES(EMPLOYEES_ID)
);


DROP TABLE MANAGERS;
DROP TABLE REIMBURSEMENT;
DROP TABLE EMPLOYEES;
