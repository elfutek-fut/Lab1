DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS flowers;


CREATE TABLE flowers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    favourite_flower_id INT,
    CONSTRAINT fk_flower
        FOREIGN KEY (favourite_flower_id) REFERENCES flowers(id)
);

INSERT INTO flowers (name) VALUES
('Roza'),
('Tulipan'),
('Narcyz'),
('Hiacynt'),
('Stokrotka');