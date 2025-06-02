package com.jimmydev.personal_finance_tracker.repository;

import com.jimmydev.personal_finance_tracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
