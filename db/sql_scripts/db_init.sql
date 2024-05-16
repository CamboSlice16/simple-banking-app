CREATE DATABASE banking_database;
USE banking_database;

CREATE TABLE accounts (
    account_id BIGINT NOT NULL AUTO_INCREMENT,
    account_type VARCHAR(255) NOT NULL DEFAULT '',
    account_balance FLOAT NOT NULL DEFAULT 0.0,
    PRIMARY KEY (account_id)
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

INSERT INTO accounts (account_id, account_type, account_balance) VALUES (1, 'checking', 1500.58);
INSERT INTO accounts (account_id, account_type, account_balance) VALUES (2, 'savings', 34668.02);
INSERT INTO accounts (account_id, account_type, account_balance) VALUES (3, 'savings', 3450.45);

INSERT INTO transactions (transaction_id, transaction_type, amount, account_to) VALUE (1, 'deposit', 1500.00, 3);
INSERT INTO transactions (transaction_id, transaction_type, amount, account_from) VALUE (2, 'withdraw', 215.45, 1);
INSERT INTO transactions (transaction_id, transaction_type, amount, account_to, account_from) VALUE (3, 'transfer', 450.00, 1, 3);
