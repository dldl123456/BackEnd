-- UPDATE
-- update user set user_balance=111 where user_id=1

-- SELECT
-- select evaluate_id, evaluate_content, movie_name from evaluate, movie WHERE evaluate.movie_id = evaluate.movie_id;

-- ADD
/*insert into evaluate(`evaluate_content`, `movie_id`, `user_id`) values ("123123", 1, 4);
SELECT * from evaluate;*/

/*SELECT evaluate_id, evaluate_content, movie_name, user_name
FROM evaluate
INNER JOIN movie
ON evaluate.movie_id = evaluate.movie_id*/

/*FROM (表1 INNER JOIN 表2 ON 表1.字段号=表2.字段号) INNER JOIN 表3 ON 表1.字段号=表3.字段号*/
/*SELECT evaluate_id, evaluate_content, movie_name, user_name
FROM (
	evaluate INNER JOIN movie ON evaluate.movie_id = evaluate.movie_id
)
INNER JOIN `user` ON evaluate.user_id = user.user_id*/

-- 三张表
-- evaluate
/*select e.evaluate_id, e.evaluate_time, e.evaluate_content , u.user_name, m.movie_name 
from user u, movie m, evaluate e 
where u.user_id = e.user_id and m.movie_id = e.movie_id;*/

-- season
#SELECT * FROM season;
/*SELECT s.season_id, c.cinema_name, h.hall_name, m.movie_name, m.movie_length, s.season_price, s.season_time, c.cinema_address
FROM season s, movie m, hall h, cinema c
WHERE s.movie_id = m.movie_id AND s.hall_id = h.hall_id AND h.cinema_id = c.cinema_id;*/

-- ticket
# 
#SELECT * FROM ticket;
/*SELECT t.ticket_id, c.cinema_name, h.hall_name, u.user_name, m.movie_name, m.movie_length, t.ticket_seat_id, s.season_price, s.season_time, c.cinema_address
FROM ticket t, season s, user u, movie m, cinema c, hall h
WHERE t.season_id = s.season_id AND t.user_id = u.user_id AND s.movie_id = m.movie_id AND s.hall_id = h.hall_id AND h.cinema_id = c.cinema_id;*/

-- 两张表
/*select * from hall;

SELECT h.hall_id, h.hall_name, c.cinema_name
FROM hall h, cinema c 
WHERE h.cinema_id = c.cinema_id*/

-- 查询user_id=1的订单信息
-- SELECT * from ticket WHERE user_id=1
SELECT t.ticket_id, u.user_name, m.movie_name, m.movie_length, t.ticket_seat_id, s.season_price, s.season_time, c.*
FROM ticket t, season s, user u, movie m, cinema c, hall h
WHERE t.season_id = s.season_id AND t.user_id = u.user_id AND s.movie_id = m.movie_id AND s.hall_id = h.hall_id AND h.cinema_id = c.cinema_id AND user_name="张三"

-- SELECT * FROM season WHERE movie_id = 2 AND hall_id = 5;

-- 根据场次id查询详细信息
/*SELECT s.season_id, c.cinema_name, h.hall_name, m.movie_name, m.movie_length, s.season_price, s.season_time, c.cinema_address
FROM season s, movie m, hall h, cinema c
WHERE s.movie_id = m.movie_id AND s.hall_id = h.hall_id AND h.cinema_id = c.cinema_id AND season_id = 1;*/
