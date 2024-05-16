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

CREATE TABLE accounts (
    account_id BIGINT NOT NULL AUTO_INCREMENT,
    account_type VARCHAR(255) NOT NULL DEFAULT '',
    account_balance FLOAT NOT NULL DEFAULT 0.0,
    PRIMARY KEY (account_id),
);