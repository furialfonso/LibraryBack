insert into editorial (ID, ADDRESS, EMAIL, MAXIMUM_BOOKS, NAME, PHONE)values(sec_id_editorial.nextval,'New York City','vikingpress@gmail.com',5,'Viking Press','3113829964');
insert into editorial (ID, ADDRESS, EMAIL, MAXIMUM_BOOKS, NAME, PHONE)values(sec_id_editorial.nextval,'83 Alexander Ln, Crows Nest NSW 2065, Australia','georgeallenunwin@gmail.com',4,'George Allen Unwin','3125983567');
insert into editorial (ID, ADDRESS, EMAIL, MAXIMUM_BOOKS, NAME, PHONE)values(sec_id_editorial.nextval,'1385 Broadway, 5th Floor, New York','bloomsburypublishing@gmail.com',7,'Bloomsbury Publishing','3118867469');
insert into editorial (ID, ADDRESS, EMAIL, MAXIMUM_BOOKS, NAME, PHONE)values(sec_id_editorial.nextval,'CORONEL OSORIO 2155 VALENTIN ALSIN PARTIDO DE LANUS BUENOS AIRES ARGENTINA ','sudamericana@gmail.com',1,'Sudamericana','3208981532');
insert into editorial (ID, ADDRESS, EMAIL, MAXIMUM_BOOKS, NAME, PHONE)values(sec_id_editorial.nextval,'Bonn Alemania','kurtwolffverlag@gmail.com',3,'Kurt Wolff Verlag','3507765031');


INSERT INTO author (ID, NAME, BIRTH_DATE, CITY_ORIGIN, EMAIL) VALUES (sec_id_author.nextval, 'Franz Kafka', null, 'Praga', 'franzKafka@gmail.com');
INSERT INTO author (ID, NAME, BIRTH_DATE, CITY_ORIGIN, EMAIL) VALUES (sec_id_author.nextval, 'JK Rowling', null, 'Yate', 'jkrowling@gmail.com');
INSERT INTO author (ID, NAME, BIRTH_DATE, CITY_ORIGIN, EMAIL) VALUES (sec_id_author.nextval, 'JRR Tolkien', null, 'Bloemfontein', 'jrrtolkien@gmail.com');
INSERT INTO author (ID, NAME, BIRTH_DATE, CITY_ORIGIN, EMAIL) VALUES (sec_id_author.nextval, 'Gabriel Garcia Marquez', null, 'Aracataca', 'gabo@gmail.com');
INSERT INTO author (ID, NAME, BIRTH_DATE, CITY_ORIGIN, EMAIL) VALUES (sec_id_author.nextval, 'Stephen King', null, 'Portland', 'stephenking@gmail.com');

insert into book (ID, GENDER, NUM_PAGES, TITLE, YEAR, AUTHOR_ID, EDITORIAL_ID) values (sec_id_books.nextval, 'Horror', 1503, 'IT', '1989',5,1);
insert into book (ID, GENDER, NUM_PAGES, TITLE, YEAR, AUTHOR_ID, EDITORIAL_ID) values (sec_id_books.nextval, 'Aventura', 423, 'El señor de los anillos la comunidad del anillo', '1954',3,2);
insert into book (ID, GENDER, NUM_PAGES, TITLE, YEAR, AUTHOR_ID, EDITORIAL_ID) values (sec_id_books.nextval, 'Aventura', 352, 'El señor de los anillos las dos torres', '1954',3,2);
insert into book (ID, GENDER, NUM_PAGES, TITLE, YEAR, AUTHOR_ID, EDITORIAL_ID) values (sec_id_books.nextval, 'Aventura', 416, 'El señor de los anillos el retorno del rey', '1955',3,2);
insert into book (ID, GENDER, NUM_PAGES, TITLE, YEAR, AUTHOR_ID, EDITORIAL_ID) values (sec_id_books.nextval, 'Literatura Fantastica', 300, 'Harry Potter y la piedra filosofal', '1997',2,3);
insert into book (ID, GENDER, NUM_PAGES, TITLE, YEAR, AUTHOR_ID, EDITORIAL_ID) values (sec_id_books.nextval, 'Literatura Fantastica', 300, 'Harry Potter y la camara secreta', '1998',2,3);
insert into book (ID, GENDER, NUM_PAGES, TITLE, YEAR, AUTHOR_ID, EDITORIAL_ID) values (sec_id_books.nextval, 'Literatura Fantastica', 300, 'Harry Potter y el prisionero de azkaban', '1999',2,3);
insert into book (ID, GENDER, NUM_PAGES, TITLE, YEAR, AUTHOR_ID, EDITORIAL_ID) values (sec_id_books.nextval, 'Literatura Fantastica', 300, 'Harry Potter y el caliz de fuego', '2000',2,3);
insert into book (ID, GENDER, NUM_PAGES, TITLE, YEAR, AUTHOR_ID, EDITORIAL_ID) values (sec_id_books.nextval, 'Literatura Fantastica', 300, 'Harry Potter y la orden del fenix', '2003',2,3);
insert into book (ID, GENDER, NUM_PAGES, TITLE, YEAR, AUTHOR_ID, EDITORIAL_ID) values (sec_id_books.nextval, 'Literatura Fantastica', 300, 'Harry Potter y el misterio del principe', '2005',2,3);
insert into book (ID, GENDER, NUM_PAGES, TITLE, YEAR, AUTHOR_ID, EDITORIAL_ID) values (sec_id_books.nextval, 'Literatura Fantastica', 300, 'Harry Potter y las reliquias de la muerte', '2007',2,3);
insert into book (ID, GENDER, NUM_PAGES, TITLE, YEAR, AUTHOR_ID, EDITORIAL_ID) values (sec_id_books.nextval, 'Novela', 471, '100 años de Soledad', '1982',4,4);
insert into book (ID, GENDER, NUM_PAGES, TITLE, YEAR, AUTHOR_ID, EDITORIAL_ID) values (sec_id_books.nextval, 'Cuento', 100, 'La Metamorfosis', '1915',1,5);