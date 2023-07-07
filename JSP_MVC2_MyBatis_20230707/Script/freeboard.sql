CREATE TABLE "FREEBOARD" (
    "IDX" NUMBER(*,0) NOT NULL, 
  "NAME" CHAR(20 BYTE) NOT NULL, 
  "PASSWORD" CHAR(20 BYTE) NOT NULL, 
  "SUBJECT" VARCHAR2(200 BYTE) NOT NULL, 
  "CONTENT" VARCHAR2(3000 BYTE) NOT NULL, 
  "WRITEDATE" TIMESTAMP (6) DEFAULT sysdate, 
  "HIT" NUMBER(*,0) DEFAULT 0, 
  "NOTICE" CHAR(3 BYTE) DEFAULT 'no', 
  "IP" CHAR(20 BYTE), 
  CONSTRAINT "FREEBOARD_PK" PRIMARY KEY ("IDX")
);

delete from freeboard;
-- drop sequence freeboard_idx_seq;
create sequence freeboard_idx_seq;

ALTER TABLE freeboard
    MODIFY idx NUMBER
    MODIFY name VARCHAR2(20)
    MODIFY password VARCHAR2(20)
    MODIFY hit NUMBER
    MODIFY notice VARCHAR2(3)
    MODIFY ip VARCHAR2(20)
;

INSERT INTO freeboard(idx, name, password, subject, content, notice, ip)
VALUES (freeboard_idx_seq.NEXTVAL, 'ㅁㅁㅁ', '1234', '아랄랄라', '여긴 어디 나는 누구?', 'no', '127.143.14.71');

COMMIT;

--UPDATE FREEBOARD SET hit = (
--  SELECT hit + 1 FROM FREEBOARD WHERE idx = 1
--) WHERE idx = 1;

SELECT * FROM freeboard;

