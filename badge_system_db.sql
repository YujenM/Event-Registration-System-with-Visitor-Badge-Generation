-- Drop user and database if they exist
DROP DATABASE IF EXISTS badge_system_db;
DROP USER IF EXISTS badgeSystem;

CREATE USER badgeSystem WITH PASSWORD 'password';
CREATE DATABASE badge_system_db WITH TEMPLATE template0 OWNER badgeSystem;

-- Connect to the database
\c badge_system_db;

-- Grant privileges to the user
ALTER DEFAULT PRIVILEGES FOR ROLE badgeSystem IN SCHEMA public GRANT ALL ON TABLES TO badgeSystem;
ALTER DEFAULT PRIVILEGES FOR ROLE badgeSystem IN SCHEMA public GRANT ALL ON SEQUENCES TO badgeSystem;

-- Create visitors table
CREATE TABLE visitors (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(20) UNIQUE NOT NULL,
    photo_path VARCHAR(255)
);
