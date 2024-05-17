CREATE DATABASE banking_database;

USE banking_database;

CREATE TABLE users (
    user_id BIGINT AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL DEFAULT 'TempPassword0',
    first_name VARCHAR(255) NOT NULL DEFAULT '',
    last_name VARCHAR(255) NOT NULL DEFAULT '',
    PRIMARY KEY (user_id)
)

CREATE TABLE accounts (
    account_id BIGINT AUTO_INCREMENT,
    account_type VARCHAR(255) NOT NULL DEFAULT '',
    account_balance DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    owner_id BIGINT NOT NULL,
    PRIMARY KEY (account_id),
    FOREIGN KEY (owner_id) REFERENCES users(user_id)
);

CREATE TABLE transactions (
    transaction_id BIGINT AUTO_INCREMENT,
    transaction_type ENUM('deposit', 'withdrawal', 'transfer'),
    amount DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    account_id BIGINT,
    timestamp TIMESTAMP,
    PRIMARY KEY (transaction_id),
    FOREIGN KEY (account_id) REFERENCES accounts(account_id)
);

INSERT INTO users (username, password, first_name, last_name) VALUES ('cam_ash', 'pa$$w0rd', 'Camdyn', 'Ashcraft');

INSERT INTO accounts (account_type, account_balance, owner_id) VALUES ('checking', 1500.58, '1');
INSERT INTO accounts (account_type, account_balance, owner_id) VALUES ('savings', 34668.02, '1');
INSERT INTO accounts (account_type, account_balance, owner_id) VALUES ('savings', 3450.45, '1');

INSERT INTO transactions (transaction_type, amount, account_id) VALUE ('deposit', 1500.00, 3);
INSERT INTO transactions (transaction_type, amount, account_id) VALUE ('withdrawal', 215.45, 1);
INSERT INTO transactions (transaction_type, amount, account_id) VALUE ('withdrawal', 450.00, 1);
INSERT INTO transactions (transaction_type, amount, account_id) VALUE ('deposit', 450.00, 3);
