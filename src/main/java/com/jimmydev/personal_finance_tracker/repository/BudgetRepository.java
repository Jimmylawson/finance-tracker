package com.jimmydev.personal_finance_tracker.repository;

import com.jimmydev.personal_finance_tracker.dto.BudgetDto.BudgetResponseDto;
import com.jimmydev.personal_finance_tracker.entity.Budget;
import com.jimmydev.personal_finance_tracker.entity.Transactions;
import com.jimmydev.personal_finance_tracker.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BudgetRepository extends JpaRepository<Budget,Long> {
    Page<Budget> findAllByUserId(Long userId, Pageable pageable);
}
