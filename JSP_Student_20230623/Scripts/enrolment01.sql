CREATE DATABASE enrolment01;
USE enrolment01;

CREATE TABLE manager(
    hakbun VARCHAR(50),
    passwd VARCHAR(16),
    name VARCHAR(10),
    address VARCHAR(100),
    tel VARCHAR(20),
    email VARCHAR(50)
);
DESC manager;
INSERT INTO manager VALUES('admin', '1111', '관리자', '경기도 구리시 교문동', '010-1111-1111','admin@naver.com');

SELECT * FROM manager;

CREATE TABLE member(
    hakbun VARCHAR(50),
    passwd VARCHAR(16),
    name VARCHAR(10),
    address VARCHAR(100),
    tel VARCHAR(20),
    email VARCHAR(50),
    major INT,
    grade INT,
    hakjom INT
);
DESC member;
INSERT INTO member VALUES('201600000', '1111', '홍길동', '경기도 성남시 상대원동', '010-1111-1111','qwer@naver.com', 1, 4, 121);
INSERT INTO member VALUES('201800000', '1111', '김순홍', '강남구 광평로 34길 25-35(수서동)',  '010-8765-9827', 'abcd@naver.com', 2 , 2, 91);
INSERT INTO member VALUES('201700000', '1111', '김미영', '경기도 구리시 교문동',  '010-8765-9827', 'abcd@naver.com', 3 , 3, 55);
SELECT * FROM member;

CREATE TABLE subject01(
    subjectNum INT,
    subjectName VARCHAR(20),
    professorName VARCHAR(10),
    hakjom INT,
    major VARCHAR(3),
    room VARCHAR(10),
    subjectPurpos VARCHAR(50),
    subjectGoal VARCHAR(50),
    subjectTest VARCHAR(15),
    grade INT,
    studentCount INT
);
DESC subject01;
INSERT INTO subject01 values(1,'C언어','홍길동', 3, '1','이공관101', 'C언어에 대해 공부', 'C 취업', '과제,시험,출석',1,30);
INSERT INTO subject01 values(2,'python언어','홍길동', 3, '1','이공관102', 'python언어에 대해 공부', 'python 취업', '과제,시험,출석',1,30);
INSERT INTO subject01 values(3,'java언어','홍길동', 3, '1','이공관103', 'java언어에 대해 공부', 'java 취업', '과제,시험,출석',1,30);
INSERT INTO subject01 values(4,'C++언어','김순홍', 3, '1','이공관201', 'C++언어에 대해 공부', 'C++ 취업', '과제,시험,출석',2,30);
INSERT INTO subject01 values(5,'unity언어','김순홍', 3, '1','이공관202', 'unity언어에 대해 공부', '게임개발 취업', '과제,시험,출석',2,30);
INSERT INTO subject01 values(6,'프론트엔드언어','김순홍', 3, '1','이공관203', 'http,css,javacript 언어에 대해 공부', '웹개발 취업', '과제,시험,출석',2,30);
INSERT INTO subject01 values(7,'jsp','김미영', 3, '1','이공관301', 'jsp언어에 대해 공부', '웹개발 취업', '과제,시험,출석',3,30);
INSERT INTO subject01 values(8,'c#','김미영', 3, '1','이공관302', 'C#언어에 대해 공부', '게임개발 취업', '과제,시험,출석',3,30);
INSERT INTO subject01 values(9,'spring','김미영', 3, '1','이공관401', 'spring언어에 대해 공부', '웹개발 취업', '과제,시험,출석',4,30);
INSERT INTO subject01 values(10,'졸업평가','홍길동', 3, '1','이공관402', '졸업하는데 필요한 이수 확인', '졸업가능하도록 도와주는 과목', '출석',4,30);
SELECT * FROM subject01;

CREATE TABLE mySubject(
    myNum INT,
    subjectNum INT,
    hakbun VARCHAR(50),
    subjectName VARCHAR(20),
    professorName VARCHAR(10),
    hakjom INT,
    major VARCHAR(3),
    grade INT
);
