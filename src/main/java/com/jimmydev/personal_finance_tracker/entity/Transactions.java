package com.jimmydev.personal_finance_tracker.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter @Setter
@RequiredArgsConstructor
@Table(name="transactions")
public class Transactions extends  BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", nullable = false)
    private Long id;

    @Column(name = "amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "type", nullable = false, length = 50)
    private String type; // e.g., "income" or "expense"

    @Column(name = "category", length = 50)
    private String category; // e.g., "food", "transport", etc.

    @Column(name = "date", nullable = false)
    private LocalDate date;

    // Date of the transaction
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; //
}
