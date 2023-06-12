CREATE TABLE users (
    num NUMBER,
    name VARCHAR2(20),
    birth NUMBER,
    ADDRESS VARCHAR2(50)
);
INSERT INTO users VALUES(1, '이서희', 20020101, '서울');
-- INSERT INTO users VALUES(2, '이지희', 20020202, '경기');
COMMIT;
