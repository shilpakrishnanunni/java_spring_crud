CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    age INTEGER NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
    );

INSERT INTO users (name, email, age, password, role)
VALUES
    ('John Doe', 'john@example.com', 28, '$2a$10$HgnDmLCq7l9hzV/TgG2XZ.ZRPbylwXHip4txMPkx9oi1SWlscgVqW', 'USER'),
    ('Jane Smith', 'jane@example.com', 32, '$2a$10$HgnDmLCq7l9hzV/TgG2XZ.ZRPbylwXHip4txMPkx9oi1SWlscgVqW', 'USER'),
    ('Bob Johnson', 'bob@example.com', 24, '$2a$10$HgnDmLCq7l9hzV/TgG2XZ.ZRPbylwXHip4txMPkx9oi1SWlscgVqW', 'USER'),
    ('Alice Williams', 'alice@example.com', 35, '$2a$10$HgnDmLCq7l9hzV/TgG2XZ.ZRPbylwXHip4txMPkx9oi1SWlscgVqW', 'STAFF'),
    ('Charlie Brown', 'charlie@example.com', 41, '$2a$10$HgnDmLCq7l9hzV/TgG2XZ.ZRPbylwXHip4txMPkx9oi1SWlscgVqW', 'ADMIN');