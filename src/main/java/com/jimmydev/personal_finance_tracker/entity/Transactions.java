package com.jimmydev.personal_finance_tracker.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public class Transactions {
    @Id
    private Long id;
    private Double amount;
    private String description;
    private String type; // e.g., "income" or "expense"
    private String category; // e.g., "food", "transport", etc.
    private LocalDate date;
    // Date of the transaction
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; //
}
