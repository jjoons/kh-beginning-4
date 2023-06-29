CREATE DATABASE joinmvcdb04;

USE joinmvcdb04;

CREATE TABLE member(
    id VARCHAR(20),
    pw VARCHAR(20),
    name VARCHAR(20),
    tel VARCHAR(20),
    email VARCHAR(30),
    field VARCHAR(20),       -- 지원분야
    skill VARCHAR(20),       -- 기술능력
    major VARCHAR(20)        -- 전공분야
);

SELECT * FROM member;
