CREATE TABLE flowers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    favourite_flower_id INT,
    CONSTRAINT fk_flower FOREIGN KEY (favourite_flower_id) REFERENCES flowers(id)
);

INSERT INTO flowers (name) VALUES ('Roza'), ('Tulipan'), ('Narcyz'), ('Hiacynt'), ('Stokrotka');