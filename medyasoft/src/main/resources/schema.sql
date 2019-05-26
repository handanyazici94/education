CREATE TABLE student(
   id serial NOT NULL,
   name VARCHAR (50) NOT NULL,
   surname VARCHAR (50) NOT NULL,
   number integer UNIQUE NOT NULL,
   age integer NOT NULL,
   PRIMARY KEY (id)
);
CREATE TABLE lesson(
   id serial NOT NULL,
   name VARCHAR (50) NOT NULL,
   code integer UNIQUE NOT NULL,
   credit integer NOT NULL,
   hour bigint NOT NULL,
   instructor VARCHAR (50) NOT NULL,
   PRIMARY KEY (id)
);
CREATE TABLE student_lesson (
  id serial NOT NULL,
  student_id bigint REFERENCES student (id),
  lesson_id bigint REFERENCES lesson (id),
  PRIMARY KEY (id)
);

CREATE TABLE employee
(
 employeeName varchar(100) NOT NULL,
  employeeId varchar(11) NOT NULL ,
 employeeAddress varchar(100) DEFAULT NULL,
 employeeEmail varchar(100) DEFAULT NULL,
 PRIMARY KEY (employeeId)
);