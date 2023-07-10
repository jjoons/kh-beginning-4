CREATE TABLE "AJAX" (
    "IDX" NUMBER(*,0) NOT NULL, 
  "NAME" CHAR(1 BYTE) NOT NULL, 
  "AGE" NUMBER(*,0) NOT NULL, 
  "GENDER" CHAR(4 BYTE) NOT NULL, 
  "EMAIL" VARCHAR2(100 BYTE) NOT NULL, 
  CONSTRAINT "AJAX_PK" PRIMARY KEY ("IDX")
);

delete from ajax;
-- drop sequence ajax_idx_seq;
create sequence ajax_idx_seq;
