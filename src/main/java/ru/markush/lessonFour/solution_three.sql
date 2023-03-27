CREATE TEMPORARY TABLE IF NOT EXISTS temp_movie_stats AS
SELECT
    m.title,
    COUNT(id) AS total_visitors,
    ROUND(AVG(visitors_per_showtime), 2) AS average_visitors_per_showtime,
    SUM(revenue) AS total_revenue
FROM movies m
         JOIN (
    SELECT
        s.movie_id,
        s.price * COUNT(t.id) AS revenue,
        COUNT(t.id) AS visitors_per_showtime
    FROM showtimes s
             LEFT JOIN tickets t ON s.id = t.showtime_id
    GROUP BY s.movie_id, s.id
) AS s ON m.id = s.movie_id
GROUP BY m.title
ORDER BY total_revenue DESC;

SELECT title, total_visitors, average_visitors_per_showtime, total_revenue
FROM temp_movie_stats
UNION
SELECT 'итого', SUM(total_visitors), ROUND(AVG(average_visitors_per_showtime), 2), SUM(total_revenue)
FROM temp_movie_stats;

