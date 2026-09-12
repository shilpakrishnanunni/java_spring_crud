CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    age INTEGER NOT NULL
);

INSERT INTO users (name, email, age)
VALUES
    ('John Doe', 'john@example.com', 28),
    ('Jane Smith', 'jane@example.com', 32),
    ('Bob Johnson', 'bob@example.com', 24),
    ('Alice Williams', 'alice@example.com', 35),
    ('Charlie Brown', 'charlie@example.com', 41);
