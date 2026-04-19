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

CREATE TABLE users_flowers (
    user_id INT NOT NULL,
    flower_id INT NOT NULL,
    PRIMARY KEY (user_id, flower_id),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_flower_rel FOREIGN KEY (flower_id) REFERENCES flowers(id) ON DELETE CASCADE
);

INSERT INTO flowers (name) VALUES ('Roza'), ('Tulipan'), ('Narcyz'), ('Hiacynt'), ('Stokrotka');