CREATE DATABASE Practical_Data;
USE Practical_Data;
CREATE TABLE Emply_data(
empno int(4) NOT NULL,
ename varchar(10),  
job varchar(9),
mgr int(4),
hiredate DATE,
sal DECIMAL(7,2),
comm DECIMAL(7,2),
deptno int(2),
PRIMARY KEY(empno)
);

USE Practical_Data;
-- USE Emply_data; 
ALTER TABLE Emply_data
ADD FOREIGN KEY (deptno); 
-- REFERENCES Emply_data(deptno);