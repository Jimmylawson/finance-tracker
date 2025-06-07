package com.jimmydev.personal_finance_tracker.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "budget")
@Builder
@RequiredArgsConstructor
public class Budget {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "budget_id", nullable = false)
    private Long id;
    @Column(name = "category", nullable = false, length = 50)
    private String category;
    @Column(name = "limit_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal limitAmount;
    @Column(name = "spent_amount", nullable = false, precision = 10, scale = 2)
    private LocalDate month;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}