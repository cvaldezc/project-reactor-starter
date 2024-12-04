CREATE TABLE IF NOT EXISTS notification (
    id SERIAL PRIMARY KEY,
    description VARCHAR(100) NOT NULL,
    completed BOOLEAN DEFAULT false,
    created_at TIMESTAMP
);