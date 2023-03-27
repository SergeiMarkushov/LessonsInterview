SELECT
    m1.title as "фильм 1",
    s1.start_time as "время начала",
    m1.duration as "длительность",
    s2.start_time as "время начала второго фильма",
    EXTRACT(EPOCH FROM (s2.start_time - (s1.start_time + INTERVAL '1 hour' * m1.duration)))/60 as "длительность перерыва (мин)"
FROM
    showtimes s1
        JOIN
    movies m1
    ON
            s1.movie_id = m1.id
        JOIN
    showtimes s2
    ON
                s1.start_time < s2.start_time
            AND s2.start_time - (s1.start_time + INTERVAL '1 hour' * m1.duration) >= INTERVAL '30 minutes'
    AND s1.id < s2.id
    AND s1.id = (SELECT MAX(id) FROM showtimes WHERE id < s2.id)
ORDER BY
    "длительность перерыва (мин)" DESC;
