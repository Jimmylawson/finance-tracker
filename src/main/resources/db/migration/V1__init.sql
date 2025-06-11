CREATE TABLE budget
(
    budget_id    BIGINT AUTO_INCREMENT NOT NULL,
    category     VARCHAR(50)    NOT NULL,
    limit_amount DECIMAL(10, 2) NOT NULL,
    spent_amount date           NOT NULL,
    user_id      BIGINT NULL,
    CONSTRAINT pk_budget PRIMARY KEY (budget_id)
);

CREATE TABLE transactions
(
    transaction_id BIGINT AUTO_INCREMENT NOT NULL,
    created_at     datetime       NOT NULL,
    created_by     VARCHAR(50)    NOT NULL,
    amount         DECIMAL(10, 2) NOT NULL,
    `description`  VARCHAR(255) NULL,
    type           VARCHAR(50)    NOT NULL,
    category       VARCHAR(50) NULL,
    date           date           NOT NULL,
    user_id        BIGINT NULL,
    CONSTRAINT pk_transactions PRIMARY KEY (transaction_id)
);

CREATE TABLE user
(
    user_id  BIGINT AUTO_INCREMENT NOT NULL,
    username VARCHAR(50)  NOT NULL,
    email    VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (user_id)
);

ALTER TABLE user
    ADD CONSTRAINT uc_user_email UNIQUE (email);

ALTER TABLE user
    ADD CONSTRAINT uc_user_username UNIQUE (username);

ALTER TABLE budget
    ADD CONSTRAINT FK_BUDGET_ON_USER FOREIGN KEY (user_id) REFERENCES user (user_id);

ALTER TABLE transactions
    ADD CONSTRAINT FK_TRANSACTIONS_ON_USER FOREIGN KEY (user_id) REFERENCES user (user_id);