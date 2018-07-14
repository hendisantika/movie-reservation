insert into CUSTOMER(NAME) values('naruto');
insert into CUSTOMER(NAME) values('sakura');
insert into CUSTOMER(NAME) values('sasuke');
insert into CUSTOMER(NAME) values('kakashi');

insert into movie (PRICE, RUNNING_TIME, TITLE) values(10000, 90, 'Antman & Wasp');
insert into movie (PRICE, RUNNING_TIME, TITLE) values(9000, 100, 'Solo');
insert into movie (PRICE, RUNNING_TIME, TITLE) values(8000, 80, 'The Avengers : Infinity War');

insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(1L,'2018-07-10 11:30:00',1);
insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(1L,'2018-07-10 12:30:00',2);
insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(1L,'2018-07-10 13:30:00',3);
insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(1L,'2018-07-10 14:30:00',4);
insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(1L,'2018-07-10 19:20:00',5);
insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(1L,'2018-07-10 21:00:00',6);
insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(1L,'2018-07-10 23:00:00',7);
insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(1L,'2018-07-10 23:55:00',8);
insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(1L,'2018-07-11 01:00:00',9);

insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(2L,'2018-07-10 12:00:00',1);
insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(2L,'2018-07-10 13:30:00',2);
insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(2L,'2018-07-10 16:30:00',3);
insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(2L,'2018-07-10 17:20:00',4);
insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(2L,'2018-07-10 22:10:00',5);


insert into DIS_COUNT(MOVIE_ID, DIS_COUNT_TYPE,PRICE) values(1, 'AMOUNT', 1000);
insert into DIS_COUNT(MOVIE_ID, DIS_COUNT_TYPE,PRICE) values(2, 'PERCENT', 10);

insert into DIS_COUNT_RULE(DISCOUNT_ID, SEQ) values(1, 1);
insert into DIS_COUNT_RULE(DISCOUNT_ID, SEQ) values(1, 9);
insert into DIS_COUNT_RULE(DISCOUNT_ID, SEQ) values(2, 2);
insert into DIS_COUNT_RULE(DISCOUNT_ID, SEQ) values(2, 5);
