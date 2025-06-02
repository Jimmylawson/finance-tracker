package com.jimmydev.personal_finance_tracker.repository;

import com.jimmydev.personal_finance_tracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
