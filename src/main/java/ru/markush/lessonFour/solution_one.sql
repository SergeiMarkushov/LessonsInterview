SELECT
    m1.title AS "фильм 1",
    s1.start_time AS "время начала",
    m1.duration AS "длительность",
    m2.title AS "фильм 2",
    s2.start_time AS "время начала",
    m2.duration AS "длительность"
FROM
    showtimes s1
        JOIN movies m1 ON s1.movie_id = m1.id
        JOIN showtimes s2 ON s1.start_time < s2.start_time AND (s1.start_time + INTERVAL '1 MINUTE' * m1.duration) > s2.start_time
        JOIN movies m2 ON s2.movie_id = m2.id
WHERE
        s1.start_time <> s2.start_time
ORDER BY
    s1.start_time;