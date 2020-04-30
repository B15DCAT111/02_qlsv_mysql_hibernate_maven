-- Create database 
CREATE SCHEMA `student_manager` DEFAULT CHARACTER SET utf8 ;


-- Create Table Student
create table student(
   id INT NOT NULL AUTO_INCREMENT,
   name VARCHAR(100),
   sex  TINYINT(1),
   bod DATE,
   PRIMARY KEY ( id )
);

--  Insert into table Student
INSERT INTO student_manager.student ( name,sex,bod ) VALUES ('Nguyen Van A',1,STR_TO_DATE('21,11,1999','%d,%m,%Y') );
INSERT INTO student_manager.student ( name,sex,bod ) VALUES ('Nguyen Van B',0,STR_TO_DATE('22,11,1999','%d,%m,%Y') );
INSERT INTO student_manager.student ( name,sex,bod ) VALUES ('Nguyen Van C',0,STR_TO_DATE('23,11,1999','%d,%m,%Y') );
INSERT INTO student_manager.student ( name,sex,bod ) VALUES ('Nguyen Van D',0,STR_TO_DATE('24,11,1999','%d,%m,%Y') );
INSERT INTO student_manager.student ( name,sex,bod ) VALUES ('Nguyen Van E',1,STR_TO_DATE('25,11,1999','%d,%m,%Y') );
INSERT INTO student_manager.student ( name,sex,bod ) VALUES ('Nguyen Van F',1,STR_TO_DATE('26,11,1999','%d,%m,%Y') );
INSERT INTO student_manager.student ( name,sex,bod ) VALUES ('Nguyen Van G',0,STR_TO_DATE('27,11,1999','%d,%m,%Y') );
INSERT INTO student_manager.student ( name,sex,bod ) VALUES ('Nguyen Van H',1,STR_TO_DATE('28,11,1999','%d,%m,%Y') );
INSERT INTO student_manager.student ( name,sex,bod ) VALUES ('Nguyen Van K',0,STR_TO_DATE('29,11,1999','%d,%m,%Y') );
INSERT INTO student_manager.student ( name,sex,bod ) VALUES ('Nguyen Van L',1,STR_TO_DATE('30,11,1999','%d,%m,%Y') );

