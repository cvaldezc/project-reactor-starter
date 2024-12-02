CREATE TABLE IF NOT EXISTS todo (
                       id SERIAL PRIMARY KEY,
                       task VARCHAR(100) NOT NULL,
                       description VARCHAR(100) NOT NULL,
                       completed BOOLEAN NOT NULL
);