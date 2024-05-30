CREATE DATABASE banking_database;

USE banking_database;

CREATE TABLE users (
    id BIGINT AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL DEFAULT 'TempPassword0',
    first_name VARCHAR(255) NOT NULL DEFAULT '',
    last_name VARCHAR(255) NOT NULL DEFAULT '',
    PRIMARY KEY (id)
);

CREATE TABLE accounts (
    id BIGINT AUTO_INCREMENT,
    type ENUM('checking', 'savings', 'credit') NOT NULL DEFAULT 'checking',
    balance DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    owner_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (owner_id) REFERENCES users(id)
);

CREATE TABLE transactions (
    id BIGINT AUTO_INCREMENT,
    type ENUM('deposit', 'withdrawal', 'transfer'),
    amount DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    account_id BIGINT,
    timestamp TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (account_id) REFERENCES accounts(id)
);

INSERT INTO users (username, password, first_name, last_name) VALUES ('cam_ash', 'pa$$w0rd', 'Camdyn', 'Ashcraft');

INSERT INTO accounts (type, balance, owner_id) VALUES ('checking', 1500.58, '1');
INSERT INTO accounts (type, balance, owner_id) VALUES ('savings', 34668.02, '1');
INSERT INTO accounts (type, balance, owner_id) VALUES ('savings', 3450.45, '1');

INSERT INTO transactions (type, amount, account_id) VALUE ('deposit', 1500.00, 3);
INSERT INTO transactions (type, amount, account_id) VALUE ('withdrawal', 215.45, 1);
INSERT INTO transactions (type, amount, account_id) VALUE ('withdrawal', 450.00, 1);
INSERT INTO transactions (type, amount, account_id) VALUE ('deposit', 450.00, 3);
