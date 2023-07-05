CREATE TABLE "KH"."GUESTBOOK" (
    "IDX" NUMBER(*,0) NOT NULL ENABLE, 
    "NAME" CHAR(20 BYTE) NOT NULL ENABLE, 
    "PASSWORD" CHAR(20 BYTE) NOT NULL ENABLE, 
    "MEMO" VARCHAR2(3000 BYTE) NOT NULL ENABLE, 
    "WRITEDATE" TIMESTAMP (6) DEFAULT sysdate, 
    "IP" CHAR(20 BYTE), 
    CONSTRAINT "GUESTBOOK_PK" PRIMARY KEY ("IDX")
);
   

delete from guestbook;

create sequence guestbook_idx_seq;

insert into guestbook(idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, '홍길동', '1111', '1등 입니다.', '192.168.100.101');
insert into guestbook(idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, '임꺽정', '2222', '2등 입니다.', '192.168.100.102');
insert into guestbook(idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, '장길산', '3333', '3등 입니다.', '192.168.100.103');
insert into guestbook(idx, name, password, memo, ip) 
values (guestbook_idx_seq.nextval, '일지매', '4444', '4등 입니다.', '192.168.100.104');

select * from guestbook;
