DROP DATABASE IF EXISTS cloudDB01;
CREATE DATABASE cloudDB01 CHARACTER SET UTF8;
USE cloudDB01;
CREATE TABLE dept
(
  deptno BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  dname VARCHAR(60),
  db_source   VARCHAR(60)
);
 
INSERT INTO dept(dname,db_source) VALUES('������',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('���²�',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('����',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('�г���',DATABASE());
INSERT INTO dept(dname,db_source) VALUES('��ά��',DATABASE());
 
SELECT * FROM dept;