INSERT INTO CUSTOMER(ID, NAME)
VALUES (1, 'naruto'),
       (2, 'sakura'),
       (3, 'sasuke'),
       (4, 'kakashi');

INSERT INTO movie (ID, PRICE, RUNNING_TIME, TITLE)
VALUES (1, 10000, 90, 'Antman & Wasp'),
       (2, 9000, 100, 'Solo'),
       (3, 8000, 80, 'The Avengers : Infinity War');

INSERT INTO SCREEN(ID, MOVIE_ID, SCREEN_TIME, SEQ)
VALUES (1, 1, '2018-07-10 11:30:00', 1),
       (2, 1, '2018-07-10 12:30:00', 2),
       (3, 1, '2018-07-10 13:30:00', 3),
       (4, 1, '2018-07-10 14:30:00', 4),
       (5, 1, '2018-07-10 19:20:00', 5),
       (6, 1, '2018-07-10 21:00:00', 6),
       (7, 1, '2018-07-10 23:00:00', 7),
       (8, 1, '2018-07-10 23:55:00', 8),
       (9, 1, '2018-07-11 01:00:00', 9),
       (10, 2, '2018-07-10 12:00:00', 10),
       (12, 2, '2018-07-10 13:30:00', 12),
       (13, 2, '2018-07-10 16:30:00', 13),
       (14, 2, '2018-07-10 17:20:00', 14),
       (15, 2, '2018-07-10 22:10:00', 15);


INSERT INTO DIS_COUNT(ID, MOVIE_ID, DIS_COUNT_TYPE, PRICE)
VALUES (1, 1, 'AMOUNT', 1000),
       (2, 2, 'PERCENT', 10);

INSERT INTO DIS_COUNT_RULE(ID, DISCOUNT_ID, SEQ)
VALUES (1, 1, 1),
       (2, 1, 9),
       (3, 2, 2),
       (4, 2, 5);
