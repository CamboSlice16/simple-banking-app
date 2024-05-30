USE banking_database;

INSERT INTO users (username, password, first_name, last_name) VALUES ('cam_ash', 'pa$$w0rd', 'Camdyn', 'Ashcraft');

INSERT INTO accounts (type, balance, owner_id) VALUES ('checking', 1500.58, '1');
INSERT INTO accounts (type, balance, owner_id) VALUES ('savings', 34668.02, '1');
INSERT INTO accounts (type, balance, owner_id) VALUES ('savings', 3450.45, '1');

INSERT INTO transactions (type, amount, account_id) VALUE ('deposit', 1500.00, 3);
INSERT INTO transactions (type, amount, account_id) VALUE ('withdrawal', 215.45, 1);
INSERT INTO transactions (type, amount, account_id) VALUE ('withdrawal', 450.00, 1);
INSERT INTO transactions (type, amount, account_id) VALUE ('deposit', 450.00, 3);