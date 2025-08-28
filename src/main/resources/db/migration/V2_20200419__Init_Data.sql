INSERT INTO customer(id, name)
VALUES (1, 'naruto'),
       (2, 'sakura'),
       (3, 'sasuke'),
       (4, 'kakashi');

INSERT INTO movie (id, price, running_time, title)
VALUES (1, 10000, 90, 'Antman & Wasp'),
       (2, 9000, 100, 'Solo'),
       (3, 8000, 80, 'The Avengers : Infinity War');

INSERT INTO screen(id, movie_id, screen_time, seq)
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

INSERT INTO dis_count(id, movie_id, dis_count_type, price)
VALUES (1, 1, 'AMOUNT', 1000),
       (2, 2, 'PERCENT', 10);

INSERT INTO dis_count_rule(id, discount_id, seq)
VALUES (1, 1, 1),
       (2, 1, 9),
       (3, 2, 2),
       (4, 2, 5);
