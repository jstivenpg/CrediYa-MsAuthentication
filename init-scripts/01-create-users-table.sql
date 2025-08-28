CREATE TABLE IF NOT EXISTS users (
    id BIG-SERIAL PRIMARY KEY,
    names VARCHAR(255) NOT NULL,
    last_names VARCHAR(255) NOT NULL,
    birthdate DATE,
    address TEXT,
    phone VARCHAR(50),
    email VARCHAR(255) UNIQUE NOT NULL,
    base_salary NUMERIC(15, 2)
);
CREATE INDEX IF NOT EXISTS idx_users_email ON users(email);
CREATE INDEX IF NOT EXISTS idx_users_names ON users(names);