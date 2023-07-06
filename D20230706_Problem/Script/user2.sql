CREATE SEQUENCE user2_no_pk START WITH 1;

CREATE TABLE user2 (
    user_no NUMBER DEFAULT user2_no_pk.NEXTVAL PRIMARY KEY,
    user_id VARCHAR2(20) UNIQUE NOT NULL,
    user_pw VARCHAR2(64) NOT NULL,
    user_name VARCHAR2(50) NOT NULL,
    user_age NUMBER NOT NULL
);

INSERT INTO user2(user_id, user_name, user_age, user_pw)
    VALUES ('hong', '홍길동', 20, '1234');
INSERT INTO user2(user_id, user_name, user_age, user_pw)
    VALUES ('han', '한소희', 25, '1234');
INSERT INTO user2(user_id, user_name, user_age, user_pw)
    VALUES ('hee', '이서희', 22, '1234');

COMMIT;
