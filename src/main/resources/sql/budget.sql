CREATE TABLE IF NOT EXISTS  budget(
    budget_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(100) NOT NULL,
    limitAmount DECIMAL(10,2) NOT NULL,
    month LOCALDATE NOT NULL,
    user_id BIGINT NOT NULL
    FOREIGN  KEY(user_id) REFERENCES user(user_id)
)