CREATE SEQUENCE d20230619p1_article_id START WITH 1;

CREATE TABLE d20230619p1_articles (
    id NUMBER DEFAULT d20230619p1_article_id.NEXTVAL PRIMARY KEY,
    writer VARCHAR2(20) NOT NULL,
    email VARCHAR2(50) NOT NULL,
    password VARCHAR2(20) NOT NULL,
    subject VARCHAR2(80) NOT NULL,
    content VARCHAR2(4000) NOT NULL,
    reg_date TIMESTAMP DEFAULT ON NULL SYSDATE NOT NULL,
    read_count NUMBER DEFAULT ON NULL 0 NOT NULL;
);

INSERT INTO D20230619P1_ARTICLES(writer, email, password, subject, content, reg_date, read_count) VALUES
    ('관리자', 'admin@example.com', 'admin', '관리자입니다', '누구나 자유롭게 글을 적으실 수 있습니다.', '2023-06-01 12:00', 3)
;
INSERT INTO D20230619P1_ARTICLES(writer, email, password, subject, content, reg_date, read_count) VALUES
    ('ㅁㄴㅇ', 'a@example.com', 'aaaaaaaa', '안녕하세요', '안녕하세요 잘 부탁드려요', '2023-06-05 20:30', 1)
;

COMMIT;
