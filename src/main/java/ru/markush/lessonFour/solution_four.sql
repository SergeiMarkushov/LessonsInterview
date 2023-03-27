SELECT
    CASE
        WHEN start_time BETWEEN '2023-03-27 09:00:00' AND '2023-03-27 15:00:00' THEN 'с 9 до 15'
        WHEN start_time BETWEEN '2023-03-27 15:00:01' AND '2023-03-27 18:00:00' THEN 'с 15 до 18'
        WHEN start_time BETWEEN '2023-03-27 18:00:01' AND '2023-03-27 21:00:00' THEN 'с 18 до 21'
        WHEN start_time BETWEEN '2023-03-27 21:00:01' AND '2023-03-28 00:00:00' THEN 'с 21 до 00'
        ELSE 'неизвестный интервал'
        END AS interval,
  COUNT(DISTINCT t.id) AS visitors,
  SUM(s.price) AS revenue
FROM showtimes s
    JOIN tickets t ON s.id = t.showtime_id
GROUP BY interval;
