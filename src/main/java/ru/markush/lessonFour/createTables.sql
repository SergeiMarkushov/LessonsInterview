CREATE TABLE IF NOT EXISTS movies(
                        id SERIAL PRIMARY KEY,
                        title VARCHAR(255) NOT NULL,
                        duration INTEGER NOT NULL CHECK (duration IN (60, 90, 120))
);

INSERT INTO movies (title, duration) VALUES
                                         ('Film 1', 189),
                                         ('Film 2', 142),
                                         ('Film 3', 136),
                                         ('Film 4', 139),
                                         ('Film 5', 175);

CREATE TABLE IF NOT EXISTS showtimes (
                           id SERIAL PRIMARY KEY,
                           movie_id INTEGER REFERENCES movies(id) ON DELETE CASCADE,
                           start_time TIMESTAMP NOT NULL,
                           price DECIMAL(6,2) NOT NULL CHECK (price > 0)
);

INSERT INTO showtimes (movie_id, start_time, price) VALUES
                                                        (1, '2023-03-27 14:00:00', 250.00),
                                                        (1, '2023-03-27 17:00:00', 350.00),
                                                        (2, '2023-03-27 13:30:00', 200.00),
                                                        (2, '2023-03-27 16:30:00', 300.00),
                                                        (3, '2023-03-27 15:00:00', 220.00),
                                                        (4, '2023-03-27 19:00:00', 280.00),
                                                        (5, '2023-03-27 18:00:00', 260.00);

CREATE TABLE IF NOT EXISTS tickets (
                         id SERIAL PRIMARY KEY,
                         showtime_id INTEGER REFERENCES showtimes(id) ON DELETE CASCADE
);

INSERT INTO tickets (showtime_id) VALUES
                                      (1),
                                      (1),
                                      (2),
                                      (3),
                                      (4),
                                      (4),
                                      (4),
                                      (5),
                                      (6),
                                      (6),
                                      (6),
                                      (7),
                                      (7),
                                      (7),
                                      (7),
                                      (7),
                                      (7),
                                      (7),
                                      (7);