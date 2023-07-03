CREATE DATABASE mvc2_board;
use mvc2_board;
create table board(
  num int(10),
  writer varchar(20),
  email varchar(20),
  subject varchar(50),
  password varchar(20),
  reg_date date,
  ref int(10),
  re_step int(10),
  re_level int(10),
  readcount int(10),
  content varchar(20)
);
select *
from board;
ALTER TABLE board
ADD CONSTRAINT board_num_pk PRIMARY KEY(num);
ALTER TABLE board
MODIFY COLUMN num INT AUTO_INCREMENT COMMENT '게시글 번호',
  MODIFY COLUMN writer VARCHAR(50) COMMENT '작성자',
  MODIFY COLUMN email VARCHAR(50) COMMENT '이메일',
  MODIFY COLUMN subject VARCHAR(100) COMMENT '이메일 주소',
  MODIFY COLUMN `password` VARCHAR(128) COMMENT '비밀번호',
  MODIFY COLUMN reg_date DATE COMMENT '등록일자',
  MODIFY COLUMN `ref` INT COMMENT '댓글끼리 묶기 위해서 사용',
  MODIFY COLUMN re_step INT COMMENT '댓글 순서',
  MODIFY COLUMN re_level INT COMMENT '들여쓰기 (댓글의 댓글)',
  MODIFY COLUMN readcount INT COMMENT '조회수',
  MODIFY COLUMN content VARCHAR(4096) COMMENT '내용';
INSERT INTO board(
    writer,
    email,
    subject,
    `password`,
    reg_date,
    `ref`,
    re_step,
    re_level,
    readcount,
    content
  )
VALUES (
    '관리자',
    'admin@example.com',
    '관리자입니다',
    'admin',
    '2023-06-30',
    0,
    0,
    0,
    1,
    '누구나 자유롭게 글을 쓰시면서 놀 수 있습니다~'
  );