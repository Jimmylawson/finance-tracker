CREATE TABLE IF NOT EXISTS transactions(
    transaction_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    amount DECIMAL(10,2) NOT NULL,
    description VARCHAR(400)  NOT NULL,
    type VARCHAR(50) NOT NULL,
    category VARCHAR(100) NOT NULL,
    date DATE NOT NULL,
    user_id BIGINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    created_by VARCHAR(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user(user_id)

)