package com.jimmydev.personal_finance_tracker.repository;

import com.jimmydev.personal_finance_tracker.entity.Budget;
import com.jimmydev.personal_finance_tracker.entity.Transactions;
import com.jimmydev.personal_finance_tracker.entity.User;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface TransactionRepository extends JpaRepository<Transactions,Long> {
    Page<Transactions> findAllByUserId(Long userId, Pageable pageable);
    @Query("SELECT SUM(t.amount) FROM Transactions t WHERE t.user.id = :userId ANd t.type =:type AND t.date BETWEEN :startDate ANd :endDate")
    BigDecimal sumByUserAndTypeAndDateRange(
            @Param("userId") Long userId,
            @Param("type") String type,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

}
