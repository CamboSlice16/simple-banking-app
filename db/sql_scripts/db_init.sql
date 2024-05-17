CREATE DATABASE banking_database;
USE banking_database;

CREATE TABLE users (
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL DEFAULT 'TempPassword0',
    first_name VARCHAR(255) NOT NULL DEFAULT '',
    last_name VARCHAR(255) NOT NULL DEFAULT '',
    PRIMARY KEY (username)
)

CREATE TABLE accounts (
    account_id BIGINT NOT NULL AUTO_INCREMENT,
    account_type VARCHAR(255) NOT NULL DEFAULT '',
    account_balance FLOAT NOT NULL DEFAULT 0.0,
    owner_id VARCHAR(255) NOT NULL,
    PRIMARY KEY (account_id),
    FOREIGN KEY (owner_id) REFERENCES users(username)
);

CREATE TABLE transactions (
    transaction_id BIGINT NOT NULL AUTO_INCREMENT,
    transaction_type VARCHAR(255) NOT NULL DEFAULT '',
    amount FLOAT NOT NULL DEFAULT 0,
    account_to BIGINT,
    account_from BIGINT,
    PRIMARY KEY (transaction_id),
    FOREIGN KEY (account_to) REFERENCES accounts(account_id),
    FOREIGN KEY (account_from) REFERENCES accounts(account_id)
);

INSERT INTO users (username, password, first_name, last_name) VALUES ('cam_ash', 'pa$$w0rd', 'Camdyn', 'Ashcraft');

INSERT INTO accounts (account_type, account_balance, owner_id) VALUES ('checking', 1500.58, 'cam_ash');
INSERT INTO accounts (account_type, account_balance, owner_id) VALUES ('savings', 34668.02, 'cam_ash');
INSERT INTO accounts (account_type, account_balance, owner_id) VALUES ('savings', 3450.45, 'cam_ash');

INSERT INTO transactions (transaction_type, amount, account_to) VALUE ('deposit', 1500.00, 3);
INSERT INTO transactions (transaction_type, amount, account_from) VALUE ('withdraw', 215.45, 1);
INSERT INTO transactions (transaction_type, amount, account_to, account_from) VALUE ('transfer', 450.00, 1, 3);
