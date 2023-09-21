
-- БАЗА ДАНИХ
-- Можливість створення БД з метою уникнення некваліфікованих
-- дій, краще залишити за розробником.
-- Тому такий функціонал у додатку не прописуємо.
-- Можемо створити БД через візуальний інструмент, наприклад,
-- MySQL Workbench.
CREATE DATABASE demo_db;

-- ТАБЛИЦІ
-- Можливість створення таблиць БД, з метою уникнення некваліфікованих
-- дій, краще залишити за розробником.
-- Тому такий функціонал у додатку не прописуємо.
-- Попередньо, необхідно спроектувати таблиці та їх зв'язки,
-- на основі сутностей реального світу.
-- Можемо створити таблиці БД через візуальний інструмент, наприклад,
-- MySQL Workbench.

CREATE TABLE IF NOT EXISTS contacts1
( id INTEGER NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(128) NOT NULL,
    first_name VARCHAR(128) NOT NULL,
    last_name VARCHAR(128) NOT NULL,
    email VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);


-- HQL
INSERT INTO User (user_name, first_name, last_name,  email) VALUES (:user_name, :first_name, :last_name, :phone, :email)
-- SQL
INSERT INTO users1 (user_name, first_name, last_name,  email) VALUES (:user_name, :first_name, :last_name, :phone, :email)


-- HQL
FROM User
-- SQL
SELECT * FROM users1


-- HQL
UPDATE User SET email = :email WHERE id = :id
-- SQL
UPDATE users1 SET email = :email WHERE id = :id


-- HQL
DELETE FROM User WHERE id = :id
-- SQL
DELETE FROM users1 WHERE id = :id;
