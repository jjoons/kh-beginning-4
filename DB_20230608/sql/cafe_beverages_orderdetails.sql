-- ����
CREATE SEQUENCE beverage_id START WITH 1;
CREATE SEQUENCE order_detail_id START WITH 1;

CREATE TABLE beverages (
  id NUMBER DEFAULT beverage_id.NEXTVAL PRIMARY KEY,
  name VARCHAR2(120),
  price NUMBER,
  btype VARCHAR2(40)
);

-- �ֹ�����
CREATE TABLE order_details (
  id NUMBER DEFAULT order_detail_id.NEXTVAL PRIMARY KEY,
  order_id NUMBER,
  beverage_id NUMBER REFERENCES beverages(id),
  count NUMBER
);

-- ����(beverages)
INSERT INTO beverages(name, price, btype) VALUES
    ('�Ƹ޸�ī��',   4500, 'COFFEE');
INSERT INTO beverages(name, price, btype) VALUES
    ('��',        5000, 'COFFEE');
INSERT INTO beverages(name, price, btype) VALUES
    ('īǪġ��',     5000, 'COFFEE');
INSERT INTO beverages(name, price, btype) VALUES
    ('ī���ī',     5500, 'COFFEE');
INSERT INTO beverages(name, price, btype) VALUES
    ('�ݵ���',     5200, 'COFFEE');
INSERT INTO beverages(name, price, btype) VALUES
    ('���� ���̵�',  3800, 'AID');
INSERT INTO beverages(name, price, btype) VALUES
    ('�ڸ� ���̵�',  4800, 'AID');
INSERT INTO beverages(name, price, btype) VALUES
    ('�ٴҶ� ����ũ', 5800, 'SHAKE');

-- �ֹ�����(order_details)
INSERT INTO order_details(order_id, beverage_id, count) VALUES(1,  1, 1);
INSERT INTO order_details(order_id, beverage_id, count) VALUES(2,  1, 2);
INSERT INTO order_details(order_id, beverage_id, count) VALUES(2,  2, 3);
INSERT INTO order_details(order_id, beverage_id, count) VALUES(2,  8, 2);
INSERT INTO order_details(order_id, beverage_id, count) VALUES(3,  1, 2);
INSERT INTO order_details(order_id, beverage_id, count) VALUES(4,  8, 1);
INSERT INTO order_details(order_id, beverage_id, count) VALUES(5,  4, 1);
INSERT INTO order_details(order_id, beverage_id, count) VALUES(6,  5, 3);
INSERT INTO order_details(order_id, beverage_id, count) VALUES(7,  1, 3);
INSERT INTO order_details(order_id, beverage_id, count) VALUES(7,  2, 2);
INSERT INTO order_details(order_id, beverage_id, count) VALUES(8,  1, 1);
INSERT INTO order_details(order_id, beverage_id, count) VALUES(9,  5, 1);
INSERT INTO order_details(order_id, beverage_id, count) VALUES(10, 1, 4);
INSERT INTO order_details(order_id, beverage_id, count) VALUES(11, 2, 1);
INSERT INTO order_details(order_id, beverage_id, count) VALUES(12, 3, 1);
INSERT INTO order_details(order_id, beverage_id, count) VALUES(13, 1, 6);
INSERT INTO order_details(order_id, beverage_id, count) VALUES(14, 1, 8);
INSERT INTO order_details(order_id, beverage_id, count) VALUES(14, 2, 2);
INSERT INTO order_details(order_id, beverage_id, count) VALUES(14, 6, 1);
INSERT INTO order_details(order_id, beverage_id, count) VALUES(15, 1, 4);
