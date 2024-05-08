INSERT INTO accounts (account_id, account_type, account_balance) VALUES (1, "checking", 1500.58);
INSERT INTO accounts (account_id, account_type, account_balance) VALUES (2, "savings", 34668.02);
INSERT INTO accounts (account_id, account_type, account_balance) VALUES (3, "savings", 3450.45);

INSERT INTO transactions (transaction_id, transaction_type, amount, account_to) VALUE (1, "deposit", 1500.00, 3);
INSERT INTO transactions (transaction_id, transaction_type, amount, account_from) VALUE (2, "withdraw", 215.45, 1);
INSERT INTO transactions (transaction_id, transaction_type, amount, account_to, account_from) VALUE (3, "transfer", 1, 3, 450.00);