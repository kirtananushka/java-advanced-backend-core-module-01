CREATE TABLE users
(
    name     VARCHAR(255) PRIMARY KEY,
    surname  VARCHAR(255),
    birthday DATE
);

CREATE TABLE subscriptions
(
    bankcard_number VARCHAR(255) PRIMARY KEY,
    start_date      DATE NOT NULL
);
