create database memolists;

USE memolists;

create table memolist1(
    idx int auto_increment primary key,
    name  varchar(50),
    password varchar(50),
    memo varchar(200),
    ip   varchar(50));

INSERT INTO memolist1(NAME, PASSWORD, memo, ip) VALUES ('홍길동', '1111', '1등 입니다.', '192.168.100.001');
INSERT INTO memolist1(NAME, PASSWORD, memo, ip) VALUES ('임꺽정', '2222', '2등 입니다.', '192.168.100.002');
INSERT INTO memolist1(NAME, PASSWORD, memo, ip) VALUES ('장길산', '3333', '3등 입니다.', '192.168.100.003');
INSERT INTO memolist1(NAME, PASSWORD, memo, ip) VALUES ('일지매', '4444', '4등 입니다.', '192.168.100.004');


SELECT * FROM memolist1;
