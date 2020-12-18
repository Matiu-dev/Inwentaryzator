DROP TABLE IF EXISTS user CASCADE;

--table user
CREATE TABLE worker
(
    id INTEGER PRIMARY KEY,
    login varchar(255)    NOT NULL,
    password  varchar(255)    NOT NULL,
    role  varchar(255)    NOT NULL,
);

insert into worker(id, login, password, role) values (1,'Jan','pass','ROLE_WORKER');

--table product

CREATE TABLE worker
(
    ean INTEGER PRIMARY KEY,
    price REAL  NOT NULL,
    number  INTEGER    NOT NULL,
    describe  varchar(255)    NOT NULL,
);

insert into product(ean, price, number, describe) values (54637252,20.5,1,'bulka');
insert into product(ean, price, number, describe) values (54667575,1.2,2,'dzban');
insert into product(ean, price, number, describe) values (54345675,30.3,3,'telefon');
insert into product(ean, price, number, describe) values (12234805,40.5,4,'lampa');
insert into product(ean, price, number, describe) values (32645675,50,5,'ksiazla');