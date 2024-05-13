CREATE TABLE transactions (
    transaction_id BIGINT NOT NULL AUTO_INCREMENT,
    transaction_type VARCHAR(255) NOT NULL DEFAULT '',
    amount FLOAT NOT NULL DEFAULT 0,
    account_to BIGINT,
    account_from BIGINT
);

CREATE TABLE accounts (
    account_id BIGINT NOT NULL AUTO_INCREMENT,
    account_type VARCHAR(255) NOT NULL DEFAULT '',
    account_balance FLOAT NOT NULL DEFAULT 0.0
);